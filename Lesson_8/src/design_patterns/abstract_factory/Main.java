package design_patterns.abstract_factory;

import design_patterns.factory.Phone;

public class Main {

    public static void main(String[] args) {


//        Phone spartiphone = new SmartphoneFactory().createPhone("smartiphone");
        PhoneFactory smartFactory = PhoneAbstractFactory.getPhoneFactory("iphone");
        Phone smartiphone = smartFactory.createPhone("iphone");


        System.out.println(smartiphone.getClass().getName());


    }

}
