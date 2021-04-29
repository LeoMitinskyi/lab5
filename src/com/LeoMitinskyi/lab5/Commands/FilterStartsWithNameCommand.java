package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
import java.io.IOException;

public class FilterStartsWithNameCommand extends Command{
    public FilterStartsWithNameCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        ioManager.writeLine("Введите подстроку:");
        String substring = ioManager.read();
        ioManager.writeLine(collection.subStringSearcher(substring));
    }

    @Override
    public String getDescription() {
        return ":вывести элементы, значение поля name которых начинается с заданной подстроки";
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
