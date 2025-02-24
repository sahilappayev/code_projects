package design_patterns.factory;

public class Main {

    public static void main(String[] args) {

        Phone samsung = new SimplePhoneFactory().createPhone("iphone");

        System.out.println(samsung.getClass().getName());

    }


}
