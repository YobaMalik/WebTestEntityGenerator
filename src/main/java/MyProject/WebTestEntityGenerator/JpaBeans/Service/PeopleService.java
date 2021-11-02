package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Interface.IFactory;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.PeopleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Getter
    private IFactory factory;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, IFactory factory){
        this.peopleRepository = peopleRepository;
        this.factory = factory;
    }
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

    public List<Person> findAll(List<Long> peopleId){
        return peopleRepository.findAllById(peopleId);
    }

    public String getStringPhoneNumber(Person person){
        String temp = person.getPhoneNumber().toString();
        return temp.length() == 11?temp.charAt(0) + "-" + temp.substring(1,4) + "-" + temp.substring(4,7) + "-" +
                temp.substring(7,9) + "-" + temp.substring(9,11):temp;
    }

}
