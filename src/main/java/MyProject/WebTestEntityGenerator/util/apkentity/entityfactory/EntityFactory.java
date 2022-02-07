package MyProject.WebTestEntityGenerator.util.apkentity.entityfactory;


import MyProject.WebTestEntityGenerator.util.apkentity.dao.ConfigHandler;
import MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface.IFactory;
import MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface.IGenerator;
import MyProject.WebTestEntityGenerator.db.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EntityFactory implements IFactory {

    private Person newSingleInstance(){
        Person person = new Person();
        IGenerator generator = new RandomValueGenerator();

        String firstName = generator.randomEntity(
                ConfigHandler.getValuesFromConfig().get("firstName"));

        String middleName = generator.randomEntity(
                ConfigHandler.getValuesFromConfig().get("middleName"));

        String lastName = new RandomValueGenerator().randomEntity(
                ConfigHandler.getValuesFromConfig().get("lastName"));

        person.setFirstName(firstName);
        person.setMiddleName(middleName);
        person.setLastName(lastName);
        person.setPhoneNumber(this.newPhoneNumber());
        person.setEmail(createEmail(person));
        return person;
    }

    private String createEmail(Person person){
        return person.getFirstName()+person.getLastName()+"@gmail.com";
    }

    private Long newPhoneNumber(){
        return 89000000000L + ThreadLocalRandom.current().nextLong(1L,999999999L);
    }

    @Override
    public Person newInstanse(){
        return newSingleInstance();
    }

    @Override
    public List<Person> newInstanse(long entityCount){
        List<Person> people = new ArrayList<>();
        for (int i = 0; i <= entityCount; i++){
            people.add(newSingleInstance());
        }
        return people;
    }

}
