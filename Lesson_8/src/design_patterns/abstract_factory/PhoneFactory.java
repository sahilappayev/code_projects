package design_patterns.abstract_factory;

import design_patterns.factory.Phone;

public interface PhoneFactory {

    Phone createPhone(String type);

}
