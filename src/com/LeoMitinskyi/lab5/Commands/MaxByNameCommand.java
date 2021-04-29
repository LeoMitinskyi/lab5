package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

public class MaxByNameCommand extends Command{
    public MaxByNameCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        if (collection.MaxName().getName() != null ){
            ioManager.writeLine(collection.MaxName().toString());
        }else{
            ioManager.writeLine("Коллекция пуста");
        }
    }

    @Override
    public String getDescription() {
        return ":вывести любой объект из коллекции, значение поля name которого является максимальным";
    }

    @Override
    public String getName() {
        return "max_by_name";
    }
}
