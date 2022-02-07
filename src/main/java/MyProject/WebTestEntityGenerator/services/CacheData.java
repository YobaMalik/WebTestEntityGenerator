package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.Person;
import MyProject.WebTestEntityGenerator.db.repository.PeopleRepository;
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
    PeopleRepository peopleRepository;
    private  Map<Long,String> lastNameMap;

    public CacheData(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<Long> getLatNameContaining(String lastNameRequest){
        if (lastNameMap == null) {
            lastNameMap =
                    peopleRepository.findAll().stream().collect(
                            Collectors.toConcurrentMap(Person::getId, Person::getLastName));
        }
        List<Long> result = new ArrayList<>();
        lastNameMap.forEach((k, v) -> {
            if(v.contains(lastNameRequest)) result.add(k);
        });
        result.forEach(System.out::println);
        return result;
    }

}
