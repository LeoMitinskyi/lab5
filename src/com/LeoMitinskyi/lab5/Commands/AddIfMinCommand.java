package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

import java.io.IOException;

public class AddIfMinCommand extends Command{
    public AddIfMinCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException{
        Integer minHeight = collection.findMinHeight();
        Integer height = ioManager.IntegerReader("Введите рост человека. Если он будет наименьшим, то вы сможете добавить нового человека");
        if (height < minHeight) {
            AddCommand addCommand = new AddCommand(engine);
            addCommand.execute();
        }
        else{
            ioManager.writeLine("Рост не является минимальным.");
        }
    }

    @Override
    public String getDescription() {
        return ":добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
