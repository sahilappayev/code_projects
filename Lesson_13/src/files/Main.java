package files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // stream base vs writer/reader base
        // byte base (streams)
        // character base (writer/reader)
//        InputStream
//        OutputStream

        // yazmaq ve ya output
//        User user = new User("John", "Doe");
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//
//        // /Users/appayevs/Desktop
//        FileOutputStream fileOutputStream = new FileOutputStream("/Users/appayevs/Desktop/user.txt");
//
//        objectOutputStream.writeObject(user); //
//
//        fileOutputStream.write(byteArrayOutputStream.toByteArray());
//
//        byteArrayOutputStream.close();
//        objectOutputStream.close();
//        fileOutputStream.close();

//        FileInputStream fileInputStream = new FileInputStream("/Users/appayevs/Desktop/user.txt");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileInputStream.readAllBytes());
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//
//        User user = (User) objectInputStream.readObject();
//
//        fileInputStream.close();
//        byteArrayInputStream.close();
//        objectInputStream.close();
//
//        System.out.println(user);


        try (
                FileInputStream fileInputStream = new FileInputStream("/Users/appayevs/Desktop/image.png");
                FileOutputStream fileOutputStream = new FileOutputStream("image2.png")
        ) {
            fileOutputStream.write(fileInputStream.readAllBytes());
        } catch (Exception e) {
            System.err.println("OOPS!! something went wrong" + e.getMessage());
        }

    }


}
