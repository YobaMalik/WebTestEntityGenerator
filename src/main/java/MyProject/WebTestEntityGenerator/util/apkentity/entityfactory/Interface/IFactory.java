package MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface;

import MyProject.WebTestEntityGenerator.db.entity.TestPersonForSoftwareComplexEntity;

import java.util.List;

public interface IFactory {
     TestPersonForSoftwareComplexEntity newInstanse();
     List<TestPersonForSoftwareComplexEntity> newInstanse(long entityCount);
}
