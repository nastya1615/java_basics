package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/tasks/",method = RequestMethod.POST)
    public void add(String title,String descripthoin){

        Task task = new Task(title,descripthoin);

        Task newTask = taskRepository.save(task);
    }

    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> getInfomation(@RequestParam int id){

        Optional<Task> optionalTask = taskRepository.findById(id);

        if(!optionalTask.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

        return new ResponseEntity(optionalTask.get(),HttpStatus.OK);
    }

    @RequestMapping( value = "/tasks/", method = RequestMethod.GET)
    public List<Task> list(){

        Iterable<Task> taskIterable = taskRepository.findAll();

        List<Task> tasks = new ArrayList<>();

        taskIterable.forEach(task -> tasks.add(task));

        return tasks;
    }

    @RequestMapping(value = "/tasks/{id}",params = "isDone", method = RequestMethod.PATCH)
    public void readinessStatus(@RequestParam int id,@RequestParam(value = "isDone")Boolean isDone){

        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.get();
        task.setDone(isDone);
        taskRepository.save(task);



    }

    @RequestMapping(value = "/tasks/{id}",params = "description", method = RequestMethod.PATCH)
    public void changeDescription(@RequestParam int id,@RequestParam(value = "description")String description){

        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.get();
        task.setDescription(description);
        taskRepository.save(task);


    }

    @RequestMapping(value = "/tasks/{id}",params = "title", method = RequestMethod.PATCH)
    public void changeTitle(@RequestParam int id,@RequestParam(value = "title")String title){

        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.get();
        task.setTitle(title);
        taskRepository.save(task);
    }

    @RequestMapping(value = "/tasks/{id}",params = {"isDone","description","title"}, method = RequestMethod.PATCH)
    public void changeData(@RequestParam int id,@RequestParam(value = "isDone")Boolean isDone,@RequestParam(value = "description")String description,@RequestParam(value = "title")String title){

        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.get();
        task.setDone(isDone);
        task.setDescription(description);
        task.setTitle(title);
        taskRepository.save(task);
    }

    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.DELETE)
    public void delete(@RequestParam int id){

        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task= optionalTask.get();
        taskRepository.delete(task);


    }



}
