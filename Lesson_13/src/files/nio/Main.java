package files.nio;

import files.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {

        User user = new User("test 2", "test 2");

        Path path = Path.of("user_nio.txt");

        FileAttribute<Set<PosixFilePermission>> fileAttribute = PosixFilePermissions
                .asFileAttribute(Set.of(PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_READ));

        if (Files.notExists(path)) {
            System.out.println("notExists");
            path = Files.createFile(path, fileAttribute);
        }

        Files.writeString(path, user.toString(), StandardOpenOption.APPEND);

        Files.lines(path).forEach(System.out::println);


    }

}
