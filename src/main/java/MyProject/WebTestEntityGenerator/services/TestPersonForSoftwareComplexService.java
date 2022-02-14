package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.rest.dto.PersonDTO;
import MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface.IFactory;
import MyProject.WebTestEntityGenerator.db.entity.TestPersonForSoftwareComplexEntity;
import MyProject.WebTestEntityGenerator.db.repository.TestPersonForSoftwareComplexRepository;
import MyProject.WebTestEntityGenerator.util.entityhandler.PersonDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPersonForSoftwareComplexService {

    private TestPersonForSoftwareComplexRepository testPersonForSoftwareComplexRepository;
    private PersonDTOConverter personDTOConverter;
    private IFactory factory;

    @Autowired
    public TestPersonForSoftwareComplexService(TestPersonForSoftwareComplexRepository testPersonForSoftwareComplexRepository,
                                               PersonDTOConverter personDTOConverter,
                                               IFactory factory) {
        this.testPersonForSoftwareComplexRepository = testPersonForSoftwareComplexRepository;
        this.factory = factory;
        this.personDTOConverter = personDTOConverter;
    }

    public TestPersonForSoftwareComplexEntity getById(Long id) {
        return testPersonForSoftwareComplexRepository.getById(id);
    }

    public void addPerson() {
        testPersonForSoftwareComplexRepository.save(factory.newInstanse());
    }

    public void addPeople(PersonDTO personDTO) {
        testPersonForSoftwareComplexRepository.saveAll(factory.newInstanse(personDTO.getQuantity()));
    }

    public List<PersonDTO> getAllEntities() {
        return personDTOConverter.convertAllEntities(testPersonForSoftwareComplexRepository.findAll());
    }

    public List<TestPersonForSoftwareComplexEntity> findByLastNameContaining(PersonDTO personDTO) {
        return testPersonForSoftwareComplexRepository.findByLastNameContaining(personDTO.getLastName());
    }

    public void updateEntity(PersonDTO personDTO) {
        TestPersonForSoftwareComplexEntity person = testPersonForSoftwareComplexRepository.getById(personDTO.getId());
        person.setPhoneNumber(Long.parseLong(personDTO.getPhoneNumber()));
        testPersonForSoftwareComplexRepository.save(person);
    }

    public List<TestPersonForSoftwareComplexEntity> findAll(List<Long> peopleId) {
        return testPersonForSoftwareComplexRepository.findAllById(peopleId);
    }


    public PersonDTO getOnePerson() {
        return personDTOConverter.convertTOPersonDTO(factory.newInstanse());
    }
}
