package com.auefly.utli;

import com.auefly.pojo.Pet;
import org.springframework.core.convert.converter.Converter;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringToPetConverter implements Converter<String, Pet> {

    @Override
    public Pet convert(String source) {
        List<String> petPart = null;
        if(!StringUtils.isEmpty(source)){
            petPart = new ArrayList<>(List.of(source.split(",")));
        }
        Pet pet = new Pet();
        pet.setName(petPart.get(0));
        pet.setWeight(Double.valueOf(petPart.get(1)));
        return pet;
    }
}
