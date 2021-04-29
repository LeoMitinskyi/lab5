package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;
public class ExitCommand extends Command{
    public ExitCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() {
        engine.stop();
    }

    @Override
    public String getDescription() {
        return ":завершить программу (без сохранения в файл)";
    }

    @Override
    public String getName() {
        return "exit";
    }
}
