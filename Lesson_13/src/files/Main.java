package files;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // stream base vs writer/reader base
        // byte base (streams)
        // character base (writer/reader)
//        InputStream
//        OutputStream

        // yazmaq ve ya output
//        User user = new User("John 2", "Doe 2");
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//
//        File file = new File("/Users/appayevs/Desktop/user.txt");
//
//        // /Users/appayevs/Desktop
//        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
//
//        if (file.exists()) {
//            objectOutputStream.reset();
//        }
//
//        objectOutputStream.writeObject(user); //
//
//        fileOutputStream.write(byteArrayOutputStream.toByteArray());
//
//        byteArrayOutputStream.close();
//        objectOutputStream.close();
//        fileOutputStream.close();

//
//        FileInputStream fileInputStream = new FileInputStream("/Users/appayevs/Desktop/user.txt");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileInputStream.readAllBytes());
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//
//        while (true) {
//            try {
//                Object readObject = objectInputStream.readObject();
//                System.out.println(readObject);
//            }catch (Exception e){
//                break;
//            }
//        }
//
//        fileInputStream.close();
//        byteArrayInputStream.close();
//        objectInputStream.close();


//        File file = new File("/Users/appayevs/Desktop/image2.png");
//
//        if (!file.exists()) {
//            File file1 = new File("/Users/appayevs/Desktop/image.png");
//            file1.renameTo(file);
//        }
//
//        File newFile = new File("/Users/appayevs/Desktop/new_folder");
//        newFile.mkdir();
//
//        try (
//                FileInputStream fileInputStream = new FileInputStream(file);
//                FileOutputStream fileOutputStream = new FileOutputStream("/Users/appayevs/Desktop/new_folder/image3.png")
//        ) {
//
//            fileOutputStream.write(fileInputStream.readAllBytes());
//        } catch (Exception e) {
//            System.err.println("OOPS!! something went wrong" + e.getMessage());
//        }



        User user = new User("John 2", "Doe 2");

        File file = new File("/Users/appayevs/Desktop/user.txt");

        FileWriter fileWriter = new FileWriter( file, true);

        if (file.exists()){
            fileWriter.write("\n" + user);
        }else {
            fileWriter.write(user.toString());
        }

        fileWriter.close();



        FileReader fileReader = new FileReader("/Users/appayevs/Desktop/user.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        while (bufferedReader.ready()){
            String readLine = bufferedReader.readLine();
            System.out.println(readLine);
        }

        fileReader.close();


    }


}
