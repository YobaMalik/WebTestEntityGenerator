package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.WorkTask;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.WorkTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkTaskService {

    private WorkTaskRepository workTaskRepository;

    public WorkTaskService(@Autowired WorkTaskRepository workTaskRepository){
        this.workTaskRepository = workTaskRepository;
    }

    public WorkTask getWorkTaskById(String project, String taskExecutor, Date issueDate){
       return workTaskRepository.findByProjectAndTaskExecutorAndIssueDate(project, taskExecutor, issueDate);
    }

    public void saveWorkTask(WorkTask workTask){
        workTaskRepository.save(workTask);
    }

    public void saveWorkTasks(List<WorkTask> workTaskList){
        workTaskRepository.saveAll(workTaskList);
    }

    public List<WorkTask> getAllWorkTasks(){
        return workTaskRepository.findAll();
    }
}
