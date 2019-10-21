package Todolist;

import java.util.List;
import java.util.Scanner;

public class TaskSetter {

    private Program pro = new Program();
    private Scanner input = new Scanner(System.in);
    private List<Task> list2 = pro.getContainer();



    public void taskSetter() {
        Task task = new Task();
        System.out.println("Please enter your task description");
        task.setDescription(input.nextLine());

        System.out.println("Please enter a title for your task");
        task.setTitle(input.nextLine());

        System.out.println("Please enter a project title for your task");
        task.setProject(input.nextLine());

        System.out.println("Please enter the due date for your task \n" +
                "only \"day-month-year\" format is allowed");
        task.setDate(input.nextLine());

        pro.getContainer().add(task);


        System.out.println("Do you want to add more tasks?" +
                "\n Answer with Y/N");

    }

    public void taskChanger(){
        System.out.println("Please choose a task");
        String userInput = input.nextLine();
        int taskChoice = Integer.parseInt(userInput);

        Task t = list2.get(taskChoice - 1);
        if (t == null) {
            System.out.println("There is no task with the specified index");
        } else {

            System.out.println("what do you want to change in the task?" +
                    "\nChoose a number:" +
                    "\n 1.Title" +
                    "\n 2.Status" +
                    "\n 3.Description" +
                    "\n 4.Project name" +
                    "\n 5.Due Date");

            String editChoice = input.nextLine();
            switch (editChoice) {

                case "1":
                    System.out.println("Enter a new title");
                    t.setTitle(input.nextLine());
                    System.out.println(t.getTitle());
                    break;
                case "2":
                    System.out.println("Enter a status Done/Undone");
                    t.setDone(input.nextLine());
                    System.out.println(t.getDone());
                    break;
                case "3":
                    System.out.println("Enter a new description");
                    t.setDescription(input.nextLine());
                    System.out.println(t.getDescription());
                    break;
                case "4":
                    System.out.println("Enter a new project name");
                    t.setProject(input.nextLine());
                    System.out.println(t.getProject());
                    break;
                case "5":
                    System.out.println("Enter a new due date: day/month/year");
                    t.setDate(input.nextLine());
                    System.out.println(t.getDate());
                    break;
            }
        }

    }
}
