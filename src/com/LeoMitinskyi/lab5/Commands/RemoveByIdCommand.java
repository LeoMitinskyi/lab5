package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
import java.io.IOException;

public class RemoveByIdCommand extends Command{
    public RemoveByIdCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        long id = ioManager.LongReader("Enter id");
        if (collection.get(id) == null) {
            ioManager.writeLine("Элемент с заданным ключём отстутствует.");
        } else {
            collection.remove(id);
            ioManager.writeLine("Object was deleted.");
        }
    }

    @Override
    public String getDescription() {
        return ":удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove";
    }


}
