package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
public class InfoCommand extends Command{
    public InfoCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        ioManager.writeLine("Тип коллекции: " + collection.getClass());
        ioManager.writeLine("Дата инициализации: " + collection.getInitializationDate());
        ioManager.writeLine("Количество элементов: " + collection.getSize());
    }

    @Override
    public String getDescription() {
        return ":вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public String getName() {
        return "info";
    }
}
