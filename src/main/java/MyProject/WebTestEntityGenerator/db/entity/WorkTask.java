package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "WorkTaskTable")
public class WorkTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String project;
    private String taskId;
    private String taskExecutor;
    private Date issueDate;
    private Date productionDate;
    private String comment;

}
