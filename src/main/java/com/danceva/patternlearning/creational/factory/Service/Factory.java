package com.danceva.patternlearning.creational.factory.Service;

import com.danceva.patternlearning.creational.factory.dto.Iphone;
import com.danceva.patternlearning.creational.factory.dto.IphoneFactory;
import com.danceva.patternlearning.creational.factory.dto.PhoneFactory;
import com.danceva.patternlearning.creational.factory.dto.SamsungFactory;
import org.springframework.stereotype.Service;

@Service
public class Factory {
    PhoneFactory createPhoneFactory(String modelOfPhone){
        switch (modelOfPhone)
        {
            case ("Iphone"):
                return new IphoneFactory();
            case ("Samsung"):
                return new SamsungFactory();
            default:
                throw new RuntimeException(modelOfPhone + " is unknown model of phone");


        }
    }
}
