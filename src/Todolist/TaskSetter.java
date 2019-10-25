package Todolist;

import java.util.List;
import java.util.Scanner;

/**
 * TodoList.TaskSetter class.
 * A class that sets a task or changes its informations.
 *
 * @author MiladYaqo
 */
public class TaskSetter {

    private Scanner input = new Scanner(System.in);
    private Program pro = new Program();

    /**
     * A method that creates a new task object assigns information to its fields
     * and saves them to the ArrayList that is in class Program by getting that array
     * from that class.
     */
    public void taskSetter() {
        Task task = new Task();
        List<Task> list2 = pro.getContainer();

        System.out.println("Please enter your task description");
        task.setDescription(input.nextLine());

        System.out.println("Please enter a title for your task");
        task.setTitle(input.nextLine());

        System.out.println("Please enter a project title for your task");
        task.setProject(input.nextLine());

        System.out.println("Please enter the due date for your task \n" +
                "only \"day-month-year\" format is allowed");
        task.setDate(input.nextLine());

        list2.add(task);


        System.out.println("Do you want to add more tasks?" +
                "\n Answer with Y/N");

    }

    /**
     * A method that changes an already created task
     * It prints out the existing tasks and asks the user to choose one of these
     * tasks, each task has a number the user types the number of desired task.
     * Then the methods lets the user choose what to change about that task and changes it.
     */
    public void taskChanger() {
        List<Task> list2 = Program.getContainer();

        System.out.println("Please choose a task");
        String userInput = input.nextLine();
        int taskChoice = Integer.parseInt(userInput);


        if (taskChoice > Program.getContainer().size()) {
            System.out.println("There is no task with the specified index");
        } else {
            Task t = list2.get(taskChoice - 1);
            System.out.println("what do you want to change in the task?" +
                    "\nChoose a number:" +
                    "\n 1.Title" +
                    "\n 2.Status" +
                    "\n 3.Description" +
                    "\n 4.Project name" +
                    "\n 5.Due Date" +
                    "\n 6.Remove");

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
                case "6":
                    System.out.println("You're about to remove this task!\nAre you sure? Y/N");
                    String answer = input.nextLine();
                    if (answer.toLowerCase().equals("y")) {
                        Program.getContainer().remove(t);
                        System.out.println("Your task has been successfully removed!");
                        break;
                    }
                    if (answer.toLowerCase().equals("n"))
                        break;


            }
        }


    }

}
