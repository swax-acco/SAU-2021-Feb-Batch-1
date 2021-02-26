package q4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String firstName, lastName, gender;
    private int age, weight;

    public Person(String firstName, String lastName, String gender, int age, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.gender + " " + String.valueOf(age) + " " + String.valueOf(weight);
    }
}

public class q4serialize {
    //to serialize
    public static void writeToFile(Person p) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./q4/person.bin"));
        objectOutputStream.writeObject(p);
    }
    //to deserialize
    public static Person readFromFile() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./q4/person.bin"));
        return (Person) objectInputStream.readObject();
    }

    public static void main(String[] args) {
        Person person1 = new Person("Swastik", "Shrivastava", "male", 23, 65);
        try {
            writeToFile(person1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(readFromFile());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}