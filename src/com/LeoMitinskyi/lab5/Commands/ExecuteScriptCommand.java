package com.LeoMitinskyi.lab5.Commands;
import com.LeoMitinskyi.lab5.Engine;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class ExecuteScriptCommand extends Command{
    public ExecuteScriptCommand(Engine engine) {
        super(engine);
    }
    @Override
    public void execute() throws IOException, JAXBException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("text.txt"));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String str;
        ArrayList<String> list = new ArrayList<>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                ioManager.writeLine(str);
            }}
        String[] commands = list.toArray(new String[0]);
        engine.run(commands);
    }

    @Override
    public String getDescription() {
        return ":считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
