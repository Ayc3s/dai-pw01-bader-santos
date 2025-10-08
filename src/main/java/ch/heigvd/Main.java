/*
* Project Name :     dai-pw01-bader-santos
* Version      :     1.0
* Date         :     08.10.2025
* Autheur      :     Gabriel Bader, Mauro Santos
* File         :     Main.java
* Project      :     Wiki is a Java-based command-line application designed to help users easily
*                    manage personal notes or structured information — much like a simplified offline
*                    wiki system. It allows you to create, read, update, and delete text-based entries
*                    stored in a plain .txt file, using simple terminal commands.
*/

package ch.heigvd;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.Callable;


@CommandLine.Command(
        name = "Wiki",
        description = "Open and create you own wiki",
        version = "1.0.0",
        showDefaultValues = true,
        mixinStandardHelpOptions = true)
class Main implements Callable<Integer> {

    /*
    enum Mode : The reason behind this enum is to implement nicely the switch in the main,
    so we do not have 100 if else.

    It was suggested by Chatgpt, especially the "setter" to set the enum

    We saw the exemple of yours "02-01-java-ios" solution, but we thought that the scope of this project, that was enough and more practical to do it that way.
    (not splitting every command in a different file).
    */

    enum Mode { SHOWALL, ADD, MODIFY, SHOW, DELETE, DEFAULT}

    String arg; // The variable used to know what command to execute

    @CommandLine.Parameters(
            index = "0",
            description = "Destination file of the wiki, by default, will be written in default project folder",
            defaultValue = "wiki.txt")
    protected String filePath;

    Mode mode = Mode.DEFAULT; // valeur par défaut

    @Option(
            names = {"-sa", "--showall"},
            description = "Show all entry of the wiki")
    void setShowAll(boolean flag) {mode = Mode.SHOWALL;}

    @Option(
            names = {"-a","--ADD"},
            description = "Add new entry to the wiki:\n Arg1 : entry name\n Arg2 : Description\n" +
                    " Exemple : -a \"nano myNewDescription\"")
    void setAdd(String s1) {mode = Mode.ADD; arg = s1;}

    @Option(
            names = {"-m","--MODIFY"},
            description = "Modify an existing entry : -m \"nameWikiEntry newName myNewDescription\"\n" +
                    "Exemple : -m nano nanov2 \"new decription\"")
    void setModifiy(String s1) {mode = Mode.MODIFY; arg = s1;}

    @Option(
            names = {"-sh","--SHOW"},
            description = "Show an existing entry :\n Exemple: -sh \"name\"")
    void setShow(String s1) {mode = Mode.SHOW; arg = s1;}

    @Option(
            names = {"-del","--DELETE"},
            description = "Delete an existing entry :\n Exemple: -del \"name\"")
    void setDelete(String s1) {mode = Mode.DELETE; arg = s1;}

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    // switch function to execute each command
    @Override
    public Integer call() {
        switch(mode) {
            case SHOWALL -> WikiManager.ShowAll(filePath);
            case ADD -> WikiManager.Add(filePath,arg);
            case MODIFY -> WikiManager.Modify(filePath,arg);
            case SHOW -> WikiManager.Show(filePath,arg);
            case DELETE -> WikiManager.Delete(filePath,arg);
            default -> {
                spec.commandLine().usage(System.out); return 1;}
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Main()).execute(args);

        System.exit(exitCode);
    }
}