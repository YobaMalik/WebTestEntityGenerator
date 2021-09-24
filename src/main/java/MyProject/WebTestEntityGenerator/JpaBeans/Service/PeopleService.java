package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.PeopleRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    @Getter
    private EntityFactory factory;

    public Person getById(Long id){
        return peopleRepository.getById(id);
    }

    public void addPerson(){
        peopleRepository.save(factory.newInstanse());
    }

    public void addPeople(Short count){
        peopleRepository.saveAll(factory.newInstanse(count));
    }

    public Iterable<Person> getAllEntities(){
        return peopleRepository.findAll();
    }

    public List<Person> findByLastNameContaining(String lastName){
        return peopleRepository.findByLastNameContaining(lastName);
    }

    public void updateEntity(Long id,String phoneNumber){
        Person person = peopleRepository.getById(id);
        person.setPhoneNumber(Long.parseLong(phoneNumber));
        peopleRepository.save(person);
    }

}
