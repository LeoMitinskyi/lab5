package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

public class SaveCommand extends Command{
    public SaveCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute(){
        collection.save();
        ioManager.writeLine("Коллекция успешно сохранена");
    }

    @Override
    public String getDescription() {
        return ":сохранить коллекцию в файл";
    }

    @Override
    public String getName() {
        return "save";
    }
}
