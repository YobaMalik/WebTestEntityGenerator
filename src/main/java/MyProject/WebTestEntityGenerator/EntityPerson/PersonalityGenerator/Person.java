package MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Person {

    @Getter @Setter private String firstName;
    @Getter @Setter private String middleName;
    @Getter @Setter private String lastName;
    @Getter @Setter private Date date;
    @Getter @Setter private String address;
    @Getter @Setter private Long phoneNumber;

    public String getStringPhoneNumber(){
        String temp = this.phoneNumber.toString();
        return temp.charAt(0) + "-" + temp.substring(1,4) + "-" + temp.substring(4,7) + "-" +
                temp.substring(7,9) + "-" + temp.substring(9,11);
    }

}