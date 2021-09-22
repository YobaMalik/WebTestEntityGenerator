package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.PeopleRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    @Getter
    private EntityFactory factory;

    public void addPerson(){
        peopleRepository.save(factory.newInstanse());
    }

    public void addPeople(Short count){
        peopleRepository.saveAll(factory.newInstanse(count));
    }

    public Iterable<Person> getAllEntities(){
        return peopleRepository.findAll();
    }

}
