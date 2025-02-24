package design_patterns.factory;

import design_patterns.abstract_factory.PhoneFactory;

public class SimplePhoneFactory implements PhoneFactory {

    public  Phone createPhone(String type) {
        if ("Samsung".equalsIgnoreCase(type)) {
            return new Samsung();
        }
        if ("Iphone".equalsIgnoreCase(type)) {
            return new Iphone();
        }

        return null;
    }


}
