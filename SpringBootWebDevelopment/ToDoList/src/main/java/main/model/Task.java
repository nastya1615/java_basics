package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime creationTime;
    private boolean isDone;
    private String title;
    private String description;

    public Task(){

    }




    public Task(String title, String description){
        this.creationTime = LocalDateTime.now();
        this.isDone = false;
        this.title = title;
        this.description = description;


    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsDone(){
        return isDone;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
