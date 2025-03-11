package files.streams_appending;

public class Main {

    public static void main(String[] args) {

        String fileName = "people.dat";

        // Write objects
//        ObjectFileIO.writeObjectToFile(fileName, new Person("Alice", 30), true);
//        ObjectFileIO.writeObjectToFile(fileName, new Person("Bob", 25), true);
        ObjectFileIO.writeObjectToFile(fileName, new Person("Bob 3", 45), true);
        ObjectFileIO.writeObjectToFile(fileName, new Person("Bob ccc", 12), true);

        // Read objects
        System.out.println("Objects in file:");
        ObjectFileIO.readObjectsFromFile(fileName);


    }


}
