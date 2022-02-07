package MyProject.WebTestEntityGenerator.util.apkentity.entityfactory;

import MyProject.WebTestEntityGenerator.util.apkentity.entityfactory.Interface.IGenerator;

import java.util.List;

public class RandomValueGenerator implements IGenerator {

    @Override
    public String randomEntity(List<String> valueList){
        return valueList.get(this.getRandomIndex(0,valueList.size()));
    }

    private int getRandomIndex(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}