package com.auefly;

import com.auefly.pojo.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YmlPropertiesTest {
    @Test
    @DisplayName("各种类型的properties")
    public void variableTypesOfData(@Autowired Person person){
        Assertions.assertEquals("hjf", person.getUserName());
        Assertions.assertEquals(false, person.getBoss());
        Assertions.assertEquals("Mon May 21 00:00:00 HKT 2001", person.getBirth().toString());
        Assertions.assertEquals(22, person.getAge());
        Assertions.assertEquals(3, person.getInterests().length);
        Assertions.assertEquals("pony", person.getAnimal().get(3));
        Assertions.assertEquals("A", person.getScore().get("english"));
        Assertions.assertTrue(person.getSalaries().contains(2000.0));
        Assertions.assertEquals("littlePrince", person.getPet().getName());
        Assertions.assertEquals("Tuffy", person.getAllPets().get("zcy").get(0).getName());
    }
}
