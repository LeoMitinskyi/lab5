package com.LeoMitinskyi.lab5;

import com.LeoMitinskyi.lab5.Commands.*;
import com.LeoMitinskyi.lab5.types.People;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;
/**
 * класс, организующий работу комманд
 */
public class Engine {
    private final Map<String, Command> commands = new HashMap<>();
    private boolean stopFlag = false;
    private final IOManager ioManager = new IOManager();
    private final List<String> history = new LinkedList<>();
    private final People collection = new People();

       public Engine() {
        registerCommand(new HelpCommand(this));
        registerCommand(new InfoCommand(this));
        registerCommand(new ShowCommand(this));
        registerCommand(new AddCommand(this));
        registerCommand(new UpdateCommand(this));
        registerCommand(new RemoveByIdCommand(this));
        registerCommand(new ClearCommand(this));
        registerCommand(new SaveCommand(this));
        registerCommand(new ExecuteScriptCommand(this));
        registerCommand(new ExitCommand(this));
        registerCommand(new AddIfMaxCommand(this));
        registerCommand(new AddIfMinCommand(this));
        registerCommand(new HistoryCommand(this));
        registerCommand(new MaxByNameCommand(this));
        registerCommand(new CountByLocationCommand(this));
        registerCommand(new FilterStartsWithNameCommand(this));
    }

    /**
     * Метод, запускающий цикл исполнения комманд, которые будут введены пользователем.
     */
    public void run() throws IOException, JAXBException{
        while (!stopFlag) {
            readAndExecuteCommand();
        }
    }

    /**
     * Метод, осуществляющий чтение и исполнение очередной команды.
     */
    public void readAndExecuteCommand() throws IOException, JAXBException{
        Command command = readCommand();
        if (command == null) {
            ioManager.writeLine("Команда с указанным именем не найдена!");
        } else {
            command.execute();
            ioManager.writeLine("");
            history.add(command.getName());
        }
    }

    /**
     * Метод, запускающий цикл исполнения комманд.
     * @param commands массив команд, которые нужно выполнить
     */
    public void run(String[] commands) throws IOException, JAXBException{
        while (!stopFlag) {
            readAndExecuteCommands(commands);
        }
    }

    /**
     * Метод, осуществляющий чтение и исполнение очередной команды.
     * @param commands массив команд которые нужно выполнить
     */
    public void readAndExecuteCommands(String[] commands) throws IOException, JAXBException{
        for (String s : commands) {
            Command command = getCommandByName(s);
            if (command == null) {
                ioManager.writeLine("Команда с указанным именем не найдена!");
            } else {
                command.execute();
                ioManager.writeLine("");
                history.add(command.getName());
            }
        }
    }

    public Command getCommandByName(String name) {
        return commands.get(name.trim());
    }

    public List<String> getHistory() {
        return history;
    }

    /**
     * Метод, регистрирующий комманду.
     * @param command Ссылка на экземпляр комманды.
     */
    private void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public Collection<Command> getAllCommands() {
        return commands.values();
    }

    /**
     * Метод, прекращающий работу программы.
     */
    public void stop() {
        stopFlag = true;
    }

    public IOManager getIOManager() {
        return ioManager;
    }

    /**
     * Метод, осуществляющий чтение очередной комманды.
     */
    private Command readCommand() {
        String name;
        do {
            name = ioManager.readNext().trim();
        } while (name.isEmpty());
        return getCommandByName(name);
    }
    
    public People getCollection() {
        return collection;
    }

    /**
     * Метод для загрузки коллекции из файла
     * @param filename имя файла
     */
    public void loadCollectionFromFile(String filename) throws JAXBException {
            collection.loadFromFile(filename);
    }
}