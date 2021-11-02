package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.WorkTask;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
public class WorkTaskController {

    private WorkTaskService workTaskService;

    public WorkTaskController(@Autowired WorkTaskService workTaskService){
     this.workTaskService = workTaskService;
    }

    @PostMapping(path = "SaveWorkTask")
    public void getWorkTaskFromReact(@RequestBody WorkTask workTask){
        workTaskService.saveWorkTask(workTask);
    }

    @PostMapping(path = "GetWorkTasks")
    @ResponseBody
    public List<WorkTask> getWorkTasks(){
        return workTaskService.getAllWorkTasks();
    }

    @PostMapping(path = "UpdateWorkTask")
    @ResponseBody
    public void updateWorkTask(@RequestBody WorkTask workTask){
        workTaskService.saveWorkTask(workTask);
    }
}
