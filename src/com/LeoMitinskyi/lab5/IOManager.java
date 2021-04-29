package com.LeoMitinskyi.lab5;

import com.LeoMitinskyi.lab5.types.Color;
import com.LeoMitinskyi.lab5.types.Country;

import java.io.*;

import static com.LeoMitinskyi.lab5.IsDigit.*;


public class IOManager {
    private final BufferedOutputStream bufferedOutputStream;
    private final InputStreamReader inputStreamReader;

    public IOManager(){
        inputStreamReader = new InputStreamReader(System.in);
        bufferedOutputStream = new BufferedOutputStream(System.out);
    }

    public void write(String s) {
        try {
            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String s) {
        write(s + "\n");
    }

    public String readNext() {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                if (!inputStreamReader.ready()) break;
                char c = (char)inputStreamReader.read();
                if (c == '\n'){break;}
                if (stringBuilder.length() != 0 && Character.isWhitespace(c)) break;
                stringBuilder.append(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String read() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // создать экземпляр InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // экземпляр класса буферизации
        return bufferedReader.readLine();
    }

    public String StringReader(String question) throws IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty()) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return value;
    }

    /**
     * Метод для чтениния вводимых чисел типа Integer
     */
    public Integer IntegerReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !IsDigit.isInteger(value) || !(Integer.parseInt(value) > 0)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Integer.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Float
     * @param maxValue максимальное значение, которое может ввести пользователь
     */
    public Float FloatReader(String question, Float maxValue) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value) || (Float.parseFloat(value) > maxValue)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Float.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Float
     */
    public Float FloatReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isFloat(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Float.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Double
     */
    public Double DoubleReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isDouble(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Double.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых чисел типа Long
     */
    public Long LongReader(String question) throws NumberFormatException, IOException {
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || !isLong(value)) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Long.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых данных типа Color
     */
    public Color ColorReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("GREEN") && !value.equals("RED") && !value.equals("BROWN") && !value.equals("YELLOW") && !value.equals("BLACK"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Color.valueOf(value);
    }

    /**
     * Метод для чтениния вводимых данных типа Country
     */
    public Country CountryReader(String question) throws IllegalArgumentException,IOException{
        writeLine(question);
        String value = read();
        while (value.trim().isEmpty() || (!value.equals("USA") && !value.equals("SPAIN") && !value.equals("INDIA") && !value.equals("ITALY") && !value.equals("JAPAN"))) {
            writeLine("Invalid value");
            writeLine(question);
            value = read();
        }
        return Country.valueOf(value);
    }
}

