package com.example.demo7;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private TaskManagerEJB taskManagerEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve all tasks
        List<Task> tasks = taskManagerEJB.getAllTasks();

        // Output tasks as JSON
        response.setContentType("application/json");
        response.getWriter().println("[");
        for (Task task : tasks) {
            response.getWriter().println("{");
            response.getWriter().println("\"id\": " + task.getId() + ",");
            response.getWriter().println("\"title\": \"" + task.getTitle() + "\",");
            response.getWriter().println("\"description\": \"" + task.getDescription() + "\",");
            response.getWriter().println("\"completed\": " + task.isCompleted());
            response.getWriter().println("},");
        }
        response.getWriter().println("]");
    }
}

