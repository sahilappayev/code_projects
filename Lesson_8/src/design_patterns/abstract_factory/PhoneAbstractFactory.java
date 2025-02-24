package design_patterns.abstract_factory;

import design_patterns.factory.SimplePhoneFactory;

public class PhoneAbstractFactory {


    public static PhoneFactory getPhoneFactory(String type) {

        if (type == null) return null;

        String lowerCase = type.toLowerCase();

        if (lowerCase.startsWith("smart")) {
            return new SmartphoneFactory();
        } else {
            return new SimplePhoneFactory();
        }
    }


}
