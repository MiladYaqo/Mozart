package Todolist;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Task implements Serializable{

    private String description;
    private String title;
    private String project;
    private String isDone = "undone";
    private LocalDate date;



    public Task() {

    }

    public Task(String name) {
        title = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDone() {
        return isDone;
    }

    public void setDone(String done) {
        isDone = done;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String dateInput) {
        boolean valid=true;
        do {
            try {
                if (!valid) {
                    System.out.println("Please enter the due date for your task \n" +
                            "Watch out for your input");

                    Scanner input = new Scanner(System.in);
                    dateInput = input.nextLine();
                }


                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                date = LocalDate.parse(dateInput, dateFormatter);
                valid = true;


            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("You have typed invalid date!");
                valid = false;
            }
        } while (!valid);

    }


    @Override
    public String toString()
    {
        return
               "Title: " + title                + " | " +
               "Status: " + isDone              + "\n"  +
               "Description: " + description    + "\n"  +
               "Project Title: " + project      + "\n"  +
               "Due date: " + date              ;
    }
}
