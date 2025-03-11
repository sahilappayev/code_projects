package files.streams_appending;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileIO {

    public static void writeObjectToFile(String fileName, Object obj, boolean append) {

        try (FileOutputStream fos = new FileOutputStream(fileName, append);
             ObjectOutputStream oos =
                     append && new File(fileName).length() > 0 //
                     ? new AppendingObjectOutputStream(fos)
                     : new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObjectsFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    System.out.println("Read: " + obj);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}