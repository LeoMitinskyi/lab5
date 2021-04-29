package com.LeoMitinskyi.lab5.Commands;

import com.LeoMitinskyi.lab5.Engine;
import com.LeoMitinskyi.lab5.types.Person;
import java.io.IOException;

public class UpdateCommand extends Command {

    public UpdateCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException{
        long id = ioManager.LongReader("Enter id:");
        Person element = collection.get(id);
        if (element == null) {
            ioManager.writeLine("Элемент с данным ключём не найден.");
        } else {
            collection.remove(id);
            AddCommand addCommand = new AddCommand(engine);
            addCommand.execute();
        }
    }

    @Override
    public String getDescription() {
        return ":обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}
