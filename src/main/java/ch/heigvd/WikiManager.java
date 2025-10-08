/*
 * Project Name :     dai-pw01-bader-santos
 * File         :     WikiManager.java
 * Autheur      :     Gabriel Bader, Mauro Santos
 * Goal         :     This file is the main logic to manage file such as write/open/close
 *                    and to manage the wiki
 *
*/

package ch.heigvd;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WikiManager {
    public static final String END_OF_LINE = "\n";
    static ArrayList<Command> ReadFile(String filename) {
        ArrayList<Command> commands = new ArrayList<Command>();
        try {
            Reader reader = new FileReader(filename, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(" ", 2);
                commands.add(new Command(arr[0], arr[1]));
            }

            br.close();
            return commands;
        } catch (IOException e) {
            System.out.println(filename + " was not found, creating new wiki.");
            WriteFile(filename,commands);
            return commands;
        }
    }

    static void WriteFile(String filename, ArrayList<Command> commands){
        try {
            Writer writer = new FileWriter(filename, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(writer);

            for(Command command : commands ){
                bw.write(command.name + " " + command.description + END_OF_LINE);
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(filename + " was not accessable, changes weren't saved.");
        }
    }
    public static boolean Add(String filename, String args){
        String arr[] = args.split(" ", 2);
        ArrayList<Command> commands = ReadFile(filename);
        if (commands.stream().anyMatch((command -> command.name.equals(arr[0])))){
            System.out.println("Command "+arr[0]+" already exists");
            return false;
        }
        commands.add(new Command(arr[0],arr[1]));
        WriteFile(filename, commands);
        return true;
    }
    public static boolean Modify(String filename, String args){
        String arr[] = args.split(" ", 2);

        if (Delete(filename, arr[0])){
            if(Add(filename,arr[1])){
                return true;
            }
        }
        return false;

    }
    public static boolean Delete(String filename, String args){
        String arr[] = args.split(" ", 2);
        ArrayList<Command> commands = ReadFile(filename);

        if (commands.stream().noneMatch((command -> command.name.equals(arr[0])))){
            System.out.println("Command "+arr[0]+" doesn't exist");
            return false;
        }

        commands.removeIf(command -> command.name.equals(arr[0]));

        WriteFile(filename, commands);
        return true;
    }
    public static void Show(String filename, String args){
        String arr[] = args.split(" ", 2);
        ArrayList<Command> commands = ReadFile(filename);

        if (commands.stream().noneMatch((command -> command.name.equals(arr[0])))){
            System.out.println("Command "+arr[0]+" doesn't exist");
            return ;
        }

        commands.stream().filter(command -> command.name.equals(arr[0])).toList()
                    .forEach(command -> System.out.println(command.ToString()));

    }
    public static void ShowAll(String filename){

        ArrayList<Command> commands = ReadFile(filename);

        if (commands.isEmpty()){
            System.out.println(filename+" is empty");
        }

        commands.forEach(command -> System.out.println(command.ToString()));
    }
}
