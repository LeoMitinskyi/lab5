package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

public class ShowCommand extends Command{
    public ShowCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        collection.sort();
        ioManager.writeLine(collection.getPersons().toString());
    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
