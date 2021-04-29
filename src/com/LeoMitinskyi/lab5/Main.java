package com.LeoMitinskyi.lab5;

import java.io.*;
import javax.xml.bind.JAXBException;
/**
 * @author Lev Mitinskyi R3140
 */
public class Main {
    public static void main(String[] args) throws IOException, JAXBException{
        Engine engine = new Engine();
        try {
            engine.loadCollectionFromFile(String.valueOf(args[0]));
        }catch (ArrayIndexOutOfBoundsException e){
            IOManager ioManager = new IOManager();
            ioManager.writeLine("Invalid file");
            System.exit(0);
        }
        engine.run();
    }
}
