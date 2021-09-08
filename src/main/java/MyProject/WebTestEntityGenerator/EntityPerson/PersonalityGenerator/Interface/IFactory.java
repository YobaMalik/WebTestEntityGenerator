package MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Interface;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Person;

import java.util.List;

public interface IFactory {
     Person newInstanse();
     List<Person> newInstanse(int entityCount);
}
