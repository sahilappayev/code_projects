package design_patterns.abstract_factory;

import design_patterns.factory.Iphone;
import design_patterns.factory.Phone;
import design_patterns.factory.Samsung;

public class SmartphoneFactory implements PhoneFactory {

    public Phone createPhone(String type) {
        if ("SmartSamsung".equalsIgnoreCase(type)) {
            return new SmartSamsung();
        }
        if ("SmartIphone".equalsIgnoreCase(type)) {
            return new SmartIhpone();
        }

        return null;
    }


}
