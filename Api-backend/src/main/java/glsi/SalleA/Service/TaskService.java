package glsi.SalleA.Service;

import glsi.SalleA.Model.Task;
import glsi.SalleA.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
}
