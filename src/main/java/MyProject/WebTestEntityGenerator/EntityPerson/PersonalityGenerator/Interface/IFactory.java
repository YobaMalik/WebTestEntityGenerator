package MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Interface;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;

import java.util.List;

public interface IFactory {
     Person newInstanse();
     List<Person> newInstanse(long entityCount);
}
