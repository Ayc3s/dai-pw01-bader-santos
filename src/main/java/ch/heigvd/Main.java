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

    enum Mode { SHOWALL, ADD, MODIFY, SHOW, DELETE, NONE }
    String arg1;
    String arg2;
    String arg3;

    @CommandLine.Parameters(
            index = "0",
            description = "Destination file of the wiki, by default, will be written in default project folder",
            defaultValue = "wiki.txt")
    protected String filePath;

    Mode mode = Mode.NONE; // valeur par défaut

    @Option(
            names = {"--s", "-showall"},
            description = "Show all entry of the wiki")
    void setShowAll(boolean flag) {mode = Mode.SHOWALL;}

    @Option(
            names = {"--a","-ADD"},
            description = "Add new entry to the wiki:\n Arg1 : entry name\n Arg2 : \"Description\"\n" +
                    " Exemple : --a nano \"my new description\"")
    void setAdd(String s1, String s2) {mode = Mode.ADD; arg1 = s1; arg2 = s2;}

    @Option(
            names = {"--m","-MODIFY"},
            description = "Modify an existing entry : --m nameWikiEntry newName \"my new description\"\n" +
                    "Exemple : --m nano nanov2 \"new decription\"")
    void setModifiy(String s1, String s2, String s3) {mode = Mode.ADD; arg1 = s1; arg2 = s2; arg3 = s3;}


    @Override
    public Integer call() {
        switch(mode) {
            case NONE -> System.out.println("try --help or -help\n");
            case SHOWALL -> System.out.println(arg1);
            case ADD -> System.out.println(arg1 + arg2 + arg3);
            case MODIFY -> System.out.println(arg1 + arg2 + arg3);
            default -> System.out.println("ceci est la commande pour defaut lcase\n");
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Main()).execute(args);

        System.exit(exitCode);
    }
}