package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

import java.util.List;
import java.util.ListIterator;

public class HistoryCommand extends Command{
    public HistoryCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute(){
        List<String> history = engine.getHistory();
        int startIndex = Math.max(0, history.size() - 12);
        ListIterator<String> iterator = history.listIterator(startIndex);
        while (iterator.hasNext()) {
            ioManager.writeLine(iterator.next());
        }
    }

    @Override
    public String getDescription() {
        return ":вывести последние 12 команд (без их аргументов)";
    }

    @Override
    public String getName() {
        return "history";
    }
}
