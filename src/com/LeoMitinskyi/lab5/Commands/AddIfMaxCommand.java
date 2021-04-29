package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

import java.io.IOException;

public class AddIfMaxCommand extends Command {
    public AddIfMaxCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException{
        Integer maxHeight = collection.findMaxHeight();
        Integer height = ioManager.IntegerReader("Введите рост человека. Если он будет наибольшим, то вы сможете добавить нового человека");
        if (height > maxHeight) {
            AddCommand addCommand = new AddCommand(engine);
            addCommand.execute();
        }
        else{
            ioManager.writeLine("Рост не является максимальным.");
        }
    }

    @Override
    public String getDescription() {
        return ":добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_max";
    }
}
