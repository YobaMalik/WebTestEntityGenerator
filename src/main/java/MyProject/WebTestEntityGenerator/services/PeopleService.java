package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.rest.dto.PersonDTO;
import MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface.IFactory;
import MyProject.WebTestEntityGenerator.db.entity.Person;
import MyProject.WebTestEntityGenerator.db.repository.PeopleRepository;
import MyProject.WebTestEntityGenerator.util.entityhandler.PersonDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;
    private PersonDTOConverter personDTOConverter;
    private IFactory factory;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository,
                         PersonDTOConverter personDTOConverter,
                         IFactory factory) {
        this.peopleRepository = peopleRepository;
        this.factory = factory;
        this.personDTOConverter = personDTOConverter;
    }

    public Person getById(Long id) {
        return peopleRepository.getById(id);
    }

    public void addPerson() {
        peopleRepository.save(factory.newInstanse());
    }

    public void addPeople(PersonDTO personDTO) {
        peopleRepository.saveAll(factory.newInstanse(personDTO.getQuantity()));
    }

    public List<PersonDTO> getAllEntities() {
        return personDTOConverter.convertAllEntities(peopleRepository.findAll());
    }

    public List<Person> findByLastNameContaining(PersonDTO personDTO) {
        return peopleRepository.findByLastNameContaining(personDTO.getLastName());
    }

    public void updateEntity(PersonDTO personDTO) {
        Person person = peopleRepository.getById(personDTO.getId());
        person.setPhoneNumber(Long.parseLong(personDTO.getPhoneNumber()));
        peopleRepository.save(person);
    }

    public List<Person> findAll(List<Long> peopleId) {
        return peopleRepository.findAllById(peopleId);
    }


    public PersonDTO getOnePerson() {
        return personDTOConverter.convertTOPersonDTO(factory.newInstanse());
    }
}
