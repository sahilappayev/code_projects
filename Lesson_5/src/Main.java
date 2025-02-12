import first_package.FirstClass;
import java.lang.reflect.Array;
import java.util.Arrays;
import secondary_package.SecondClass;
import third_package.ThirdClass;
import third_package.test.Demo;
import third_package.test.TestClass;

public class Main {


    // public - her terefden el chatanliq var
    //
    // private - classin ve ya faylin daxilinde
    //
    // protected -  default kimi ve Hemin classdan extend elemish classlarda
    //
    // ve default - ancaq eyni paket daxilinde gorunur


    public static void main(String[] args) {


        // GIT -> remote repository vs local repository

        // main (master) - production
        // develop (development), preprod, testing
        // feature/edit_name
        // bugfix/fix-name-editing
        // hotfix/fix_payment

        // git local repository -> untracked, staged, commited


        // git clone {repo_url}
        // git init
        // git branch
        // git checkout -B feature/edit_name
        // git add {filename} ve ya git add .
        // git pull - remote deyishiklikeri chekir
        // git fetch - deyisikleri yox, onlarinda melumati
        // git push - localdakilari remota gonderir
        // git remote add origin {remote_url}
        // git push -u origin main
        // ---


        int[] numbers = {10, 6, 3, 4, 483, 2, 7, 4, 9, -7};


        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "   ");
        }

        int[] ints = Arrays.copyOf(numbers, numbers.length);

//        int[] ints = numbers;


        Arrays.sort(numbers);


        System.out.println("   ");


        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "   ");
        }

        System.out.println("============");

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "   ");
        }




    }

}
