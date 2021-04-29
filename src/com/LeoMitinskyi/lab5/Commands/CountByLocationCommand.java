package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
import java.io.IOException;

public class CountByLocationCommand extends Command{
    public CountByLocationCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException {
        Long X = ioManager.LongReader("Enter X:");
        double Y = ioManager.DoubleReader("Enter Y:");
        Float Z = ioManager.FloatReader("Enter Z:");

        ioManager.writeLine(String.valueOf(collection.LocationCounter(X,Y,Z)));
    }

    @Override
    public String getDescription() {
        return ":вывести количество элементов, значение поля location которых равно заданному";
    }

    @Override
    public String getName() {
        return "count_by_location";
    }
}
