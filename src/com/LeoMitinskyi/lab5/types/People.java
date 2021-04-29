package com.LeoMitinskyi.lab5.types;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс, реализующий методы для управления объектами коллекции
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class People {
    @XmlElement(name = "person")
    public static LinkedList<Person> persons = new LinkedList<>();
    private final LocalDate initializationDate;

    public People() {
        initializationDate = LocalDate.now();
    }

    /**
     * Отчищает коллекцию
     */
    public void clear() {
        persons.clear();
    }

    public LinkedList<Person> getPersons(){
        return persons;
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    /**
     * Возвращает размер коллекции
     */
    public int getSize() {
        return persons.size();
    }

    People people;
    /**
     * Загружает коллекцию из файла
     */
    public void loadFromFile(String filename) throws JAXBException {
        try {
            File file = new File(filename);
            JAXBContext context = JAXBContext.newInstance(People.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            people = (People) unmarshaller.unmarshal(file);
        } catch (UnmarshalException e){
            System.out.println("Invalid file");
            System.exit(0);
        }finally {
            CorrectDataReader("Data.xml");
        }
    }

    public void CorrectDataReader(String filename){
        for(Person person: persons){
            if(!(person.getHeight() > 0) || (person.getName() == null) || (person.getName() == "") || person.getEyeColor() == null
            || person.getHairColor() == null || person.getLocation() == null || person.getNationality() == null || person.getCoordinates().getX() > 962
            || person.getCoordinates().getY() > 214 || person.getLocation().getX() == null || person.getLocation().getZ() == null){
                System.out.println("Invalid values in file");
                System.exit(0);
            }
        }
    }

    /**
     * Добавляет объект в коллекцию
     */
    public void add(Person element) {
        persons.add(element);
    }

    /**
     * Сохраняет коллекцию в xml файл
     */
    public void save(){
        StringWriter sw = new StringWriter();
        try {
            People people = new People();
            JAXBContext context = JAXBContext.newInstance(People.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(people, new File("Data.xml"));

            jaxbMarshaller.marshal(people, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * удаляет объект из коллекции по его id
     */
    public void remove(long key) {
        Person element = get(key);
        persons.remove(element);
    }

    /**
     * получает человека по его id
     */
    public Person get(long id) {
        for (Person element : persons) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    /**
     * находит наибольший рост человека среди всех людей
     */
    public int findMaxHeight(){
        int max = -1;
        for (Person person : persons) {
            if (person.getHeight() > max){
                max = person.getHeight();
            }
        }
        return max;
    }


    /**
     * находит наименьший рост человека среди всех людей
     */
    public int findMinHeight(){
        int min = 100000;
        for (Person person : persons) {
            if (person.getHeight() < min){
                min = person.getHeight();
            }
        }
        return min;
    }

    /**
     * находит всех людей, чьё имя начинается с заданной подстроки
     */
    public String subStringSearcher(String subString){
        StringBuilder box = new StringBuilder();
        for (Person person : persons) {
            if (person.getName().startsWith(subString)){
                box.append(person.toString()).append("\n");
            }
        }
        return box.toString();
    }

    /**
     * подсчитывает количество людей, чьи параметры локации равны заданным
     */
    public int LocationCounter(Long X, double Y, Float Z){
        int count = 0;
        for (Person person : persons) {
            if (person.getLocation().getX().equals(X) && person.getLocation().getY() == Y && person.getLocation().getZ().equals(Z)){
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * возвращает человека с максимальным именем
     */
    public Person MaxName(){
        String minString = "";
        Person p = new Person();
        for (Person person : persons) {
            if(person.getName().compareToIgnoreCase(minString) > 0){
                minString = person.getName();
                p = person;
            }
        }
        return p;
    }

    /**
     * Сортирует людей в коллекции по имени, по алфавиту
     */
    public void sort() {
        persons.sort(Comparator.comparing(Person::getName));
    }
}
