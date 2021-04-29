package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
public class ClearCommand extends Command{
    public ClearCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        collection.clear();
        ioManager.writeLine("Коллекция очищена.");
    }

    @Override
    public String getDescription() {
        return ":очистить коллекцию";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
