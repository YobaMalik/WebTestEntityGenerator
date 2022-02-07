package MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface;

import MyProject.WebTestEntityGenerator.db.entity.Person;

import java.util.List;

public interface IFactory {
     Person newInstanse();
     List<Person> newInstanse(long entityCount);
}
