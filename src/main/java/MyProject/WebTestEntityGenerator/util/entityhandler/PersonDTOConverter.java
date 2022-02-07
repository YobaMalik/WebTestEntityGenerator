package MyProject.WebTestEntityGenerator.util.entityhandler;

import MyProject.WebTestEntityGenerator.db.entity.Person;
import MyProject.WebTestEntityGenerator.rest.dto.PersonDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonDTOConverter {
    public PersonDTO convertTOPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setEmail(person.getEmail());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setMiddleName(person.getMiddleName());
        personDTO.setLastName(person.getLastName());
        personDTO.setPhoneNumber(getStringPhoneNumber(person.getPhoneNumber()));
        return personDTO;
    }

    private String getStringPhoneNumber(Long phoneNumber) {
        String temp = Long.toString(phoneNumber);
        return temp.length() == 11 ? temp.charAt(0) + "-" + temp.substring(1, 4) + "-" + temp.substring(4, 7) + "-" +
                temp.substring(7, 9) + "-" + temp.substring(9, 11) : temp;
    }

    public List<PersonDTO> convertAllEntities(List<Person> entites) {
       return entites.stream().map(this::convertTOPersonDTO).collect(Collectors.toList());
    }
}
