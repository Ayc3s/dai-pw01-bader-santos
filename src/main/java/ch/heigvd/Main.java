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
     */

    enum Mode { SHOWALL, ADD, MODIFY, SHOW, DELETE}

    String arg;

    @CommandLine.Parameters(
            index = "0",
            description = "Destination file of the wiki, by default, will be written in default project folder",
            defaultValue = "wiki.txt")
    protected String filePath;

    Mode mode = null; // valeur par défaut

    @Option(
            names = {"-sa", "--showall"},
            description = "Show all entry of the wiki")
    void setShowAll(boolean flag) {mode = Mode.SHOWALL;}

    @Option(
            names = {"-a","--ADD"},
            description = "Add new entry to the wiki:\n Arg1 : entry name\n Arg2 : Description\n" +
                    " Exemple : --a \"nano myNewDescription\"")
    void setAdd(String s1) {mode = Mode.ADD; arg = s1;}

    @Option(
            names = {"-m","--MODIFY"},
            description = "Modify an existing entry : --m \"nameWikiEntry newName myNewDescription\"\n" +
                    "Exemple : --m nano nanov2 \"new decription\"")
    void setModifiy(String s1) {mode = Mode.MODIFY; arg = s1;}

    @Option(
            names = {"-sh","--SHOW"},
            description = "Show an existing entry :\n Exemple: --sh \"name\"")
    void setShow(String s1) {mode = Mode.SHOW; arg = s1;}

    @Option(
            names = {"-del","--DELETE"},
            description = "Delete an existing entry :\n Exemple: --del \"name\"")
    void setDelete(String s1) {mode = Mode.DELETE; arg = s1;}


    @Override
    public Integer call() {
        switch(mode) {
            case SHOWALL -> WikiManager.ShowAll(filePath);
            case ADD -> WikiManager.Add(filePath,arg);
            case MODIFY -> WikiManager.Modify(filePath,arg);
            case SHOW -> WikiManager.Show(filePath,arg);
            case DELETE -> WikiManager.Delete(filePath,arg);
            default -> System.out.println("ceci est la commande pour defaut lcase\n");
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Main()).execute(args);

        System.exit(exitCode);
    }
}