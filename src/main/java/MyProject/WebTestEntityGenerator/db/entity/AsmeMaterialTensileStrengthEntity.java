package MyProject.WebTestEntityGenerator.db.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "materials_yield")
@Entity
public class AsmeMaterialTensileStrengthEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nominalComposition;
    private String spec;
    private String grade;
    private String uns;

   // @ElementCollection
   // @CollectionTable(name = "asme_tensile_strength", joinColumns = @JoinColumn(name = "Material_ID"))
    //@ElementCollection(targetClass = String.class)
   // private List<String> temperatures = new ArrayList<>();
}
