package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "people")
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private Long id;

    @Getter @Setter private String firstName;
    @Getter @Setter private String middleName;
    @Getter @Setter private String lastName;
    @Getter @Setter private Date date;
    @Getter @Setter private String address;
    @Getter @Setter private Long phoneNumber;

    public String getStringPhoneNumber(){
        String temp = this.phoneNumber.toString();
        return temp.length() == 11?temp.charAt(0) + "-" + temp.substring(1,4) + "-" + temp.substring(4,7) + "-" +
                temp.substring(7,9) + "-" + temp.substring(9,11):temp;
    }

}