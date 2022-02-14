package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.TestPersonForSoftwareComplexEntity;
import MyProject.WebTestEntityGenerator.db.repository.TestPersonForSoftwareComplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CacheData {

    //TODO DansGame?? delete?

    @Autowired
    TestPersonForSoftwareComplexRepository peopleRepository;
    private  Map<Long,String> lastNameMap;

    public CacheData(TestPersonForSoftwareComplexRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<Long> getLatNameContaining(String lastNameRequest){
        if (lastNameMap == null) {
            lastNameMap =
                    peopleRepository.findAll().stream().collect(
                            Collectors.toConcurrentMap(TestPersonForSoftwareComplexEntity::getId, TestPersonForSoftwareComplexEntity::getLastName));
        }
        List<Long> result = new ArrayList<>();
        lastNameMap.forEach((k, v) -> {
            if(v.contains(lastNameRequest)) result.add(k);
        });
        result.forEach(System.out::println);
        return result;
    }

}
