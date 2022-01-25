package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.WorkTask;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin(maxAge = 3600)
@SessionScope
public class WorkTaskController {

    private WorkTaskService workTaskService;

    public WorkTaskController(@Autowired WorkTaskService workTaskService){
        this.workTaskService = workTaskService;
    }

    @PostMapping(path = "SaveWorkTask")
    @ResponseBody
    public void getWorkTaskFromReact(@RequestBody WorkTask workTask){
        System.out.println(workTask.toString());
        workTaskService.saveWorkTask(workTask);
    }

    @PostMapping(path = "GetWorkTasks")
    @ResponseBody
    public List<WorkTask> getWorkTasks(){
        return workTaskService.getAllWorkTasks();
    }

    @PostMapping(path = "GetOneWorkTask")
    @ResponseBody
    public WorkTask GetOneWorkTask(@RequestBody WorkTask workTask){
        Optional<WorkTask> result = workTaskService.getWorkTaskById(workTask.getId());
        return result.orElse(null);
    }

    @PostMapping(path = "UpdateWorkTask")
    @ResponseBody
    public void updateWorkTask(@RequestBody WorkTask workTask){
        workTaskService.saveWorkTask(workTask);
    }

}