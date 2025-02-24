package design_patterns.singletony;

public class Main {


    public static void main(String[] args) {


        Config config = Config.getInstance();


        Config config2 = Config.getInstance();


        System.out.println(config);
        System.out.println(config2);



    }


}
