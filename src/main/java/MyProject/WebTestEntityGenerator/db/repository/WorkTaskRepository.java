package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WorkTaskRepository extends JpaRepository<WorkTask, Long> {
    WorkTask findByProject(String project);
    WorkTask findByProjectAndTaskExecutorAndIssueDate(String project, String taskExecutor, Date issueDate);
}
