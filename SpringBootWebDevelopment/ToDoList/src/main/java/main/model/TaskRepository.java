package main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface TaskRepository extends CrudRepository <Task,Integer> {
}
