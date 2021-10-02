package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.PeopleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CacheData {

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
