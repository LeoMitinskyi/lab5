package com.LeoMitinskyi.lab5.Commands;

import com.LeoMitinskyi.lab5.Engine;
import com.LeoMitinskyi.lab5.IOManager;
import com.LeoMitinskyi.lab5.types.People;
import javax.xml.bind.JAXBException;
import java.io.IOException;
/**
 * Класс - заготовка для команд, определяет их поведение
 */
public abstract class Command {
    protected final Engine engine;
    protected final IOManager ioManager;
    protected final People collection;

    public Command(Engine engine) {
        this.engine = engine;
        this.ioManager = engine.getIOManager();
        this.collection = engine.getCollection();
    }
    /**
     * метод, который непорседственно выполняет команду
     */
    public abstract void execute() throws IOException, JAXBException;
    /**
     * метод, возвращающий описание команды
     */
    public abstract String getDescription();
    /**
     * метод, возвращающий имя команды
     */
    public abstract String getName();
}
