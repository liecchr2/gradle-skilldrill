package edu.isu.cs.cs2263.serialization;

import java.io.*;

public class Runner {

    public static void main(String[] args) {
        Professor isaac = new Professor("Isaac", "Griffith",
                new PhoneNumber("208", "282-4876"), "grifisaa@isu.edu", "BA 315");

        /* This is what the code looks like before being put into 'try' block
        FileOutputStream fos = new FileOutputStream("serial_test.obj");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        */
        //Print out Professor object
        System.out.println(isaac);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serial_test.obj"))) {
            //Write file out
            out.writeObject(isaac);
        } catch (IOException ex) {
            System.err.printf("IOException %s", ex.getMessage());
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("serial_test.obj"))){
            Professor other = (Professor) in.readObject();
            System.out.println(other);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.printf("%s: %s", ex.getClass().getSimpleName(), ex.getMessage());
        }
    }
}
