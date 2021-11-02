package MyProject.WebTestEntityGenerator.JpaBeans.Repository;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.WorkTask;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WorkTaskRepository extends JpaRepository<WorkTask, Long> {
    WorkTask findByProject(String project);
    WorkTask findByProjectAndTaskExecutorAndIssueDate(String project, String taskExecutor, Date issueDate);
}
