package com.example.demo7;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TaskManagerEJB {
    @PersistenceContext
    private EntityManager entityManager;

    // Add a task to the database
    public void addTask(Task task) {
        entityManager.persist(task);
    }

    // Get all tasks from the database
    public List<Task> getAllTasks() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    // Mark a task as completed
    public void completeTask(Long taskId) {
        Task task = entityManager.find(Task.class, taskId);
        if (task != null) {
            task.setCompleted(true);
            entityManager.merge(task);
        }
    }
}

