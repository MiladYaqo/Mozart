import java.util.*;
import java.util.stream.Collectors;


/**
 * Program Class
 * This is where everything happens, (switch) is used to implement user commands, the objects are initialised first.
 * The class takes a user input through the scanner and performs operations, the input is passed through the switch
 * statement that controls the which option to be executed.
 */


public class Program {
    Task task;
    Text text = new Text();
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    List<Task> container = new ArrayList<>();



    private void editP() {
        String answer;
        do{
            System.out.println("Which task do you want to edit? \n");
            for (Task t : container) {
                //ADD AN EXCEPTION FOR WHEN THE LIST IS EMPTY
                System.out.println(container.indexOf(t) + 1 + "." + t + "\n"); //Or t.getTitle()
            }


            System.out.println("Please choose a task");
            String userInput = input.nextLine();
            int taskChoice = Integer.parseInt(userInput);

            Task t = container.get(taskChoice-1);
            if (t != null) {

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
                        break;
                    case "3":
                        System.out.println("Enter a new description");
                        t.setDescription(input.nextLine());
                        break;
                    case "4":
                        System.out.println("Enter a new project name");
                        t.setDescription(input.nextLine());
                        break;
                    case "5":
                        System.out.println("Enter a new due date: day/month/year");
                        t.setDate(input.nextLine());
                        break;


                }

            }
            else{
                System.out.println("There is no task with the specified index");
            }

            System.out.println("Do you want to change another task?");
            answer = input.nextLine();
        } while(answer.toLowerCase() == "y");

    }


    public void run() {
        container.add(
                new Task("dsa")
        );
        container.add(
                new Task("asd")
        );
        //Printing welcome and initializing (command) as empty so the while loop works.
        text.printWelcome();
        String command;

        System.out.println();

        //A do while loop is used to let the user stay inside the program until he presses 5 which is quit!
        do {
            text.printOptions();
            command = input.nextLine();

            switch (command) {
                case "1":
                    if (container.isEmpty()) {
                        System.out.println("You have no tasks at the moment!\n");
                        break;
                    }

                    System.out.println("Choose an option" +
                            "\n 1. View all the tasks (unsorted)" +
                            "\n 2. View tasks sorted by date" +
                            "\n 3. View tasks sorted by project");
                    String option = input.nextLine();


                    switch (option) {
                        case "1":
                            System.out.println("Your tasks are: ");
                            System.out.println("--------------------");
                            container.forEach(x -> System.out.println("#" + (container.indexOf(x)+1) + "\n" + x +"\n"));
                            System.out.println("--------------------\n");
                            break;

                        case "2":
                            System.out.println("Your tasks sorted by date are: ");
                            System.out.println("--------------------");
                            container.stream()
                                    .sorted(Comparator.comparing(Task::getDate))
                                    .collect(Collectors.toList())
                                    .forEach(x -> System.out.println("#" + (container.indexOf(x)+1) + "\n" + x +"\n"));
                            System.out.println("-------------------- \n");

                            break;

                        case "3":
                            System.out.println("Your tasks sorted by project title are: ");
                            System.out.println("--------------------");
                            container.stream()
                                    .sorted(Comparator.comparing(Task::getProject))
                                    .collect(Collectors.toList())
                                    .forEach(x -> System.out.println("#" + (container.indexOf(x)+1) + "\n" + x +"\n"));
                            System.out.println("--------------------\n");
                    }
                    break;

                case "2":


                    String answer;
                    do {
                        task = new Task();
                        //Task t = new Task();
                        System.out.println("Please enter your task description");
                        task.setDescription(input.nextLine());

                        System.out.println("Please enter a title for your task");
                        task.setTitle(input.nextLine());

                        System.out.println("Please enter a project title for your task");
                        task.setProject(input.nextLine());

                        System.out.println("Please enter the due date for your task \n" +
                                "enter it as a \"day-month-year\" format (Case sensitive)");
                        task.setDate(input.nextLine());

                        container.add(task);


                        System.out.println("Do you want to add more tasks?" +
                                "\n Answer with Y/N");
                        answer = input.nextLine().toLowerCase();


                    } while (answer.equals("y"));
                    break;

                case "3":

                    editP();




            }
        } while (!command.equals("5"));
    }
}
