package ch.heigvd;

public class Command {
    String name;
    String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String ToString(){
        return name + ": " + description;
    }
}
