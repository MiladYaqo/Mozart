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
    List<Task> container = new ArrayList<>();


    public void editTask(){
        System.out.println("Which task do you want to edit?");
        for (Task tasks : container) {
            System.out.println(container.indexOf(tasks)+1 + "." + tasks.getTitle());
        }



        String choice = input.nextLine();
        switch (choice)
            


    }



    public void run() {

        //Printing welcome and initializing (command) as empty so the while loop works.
        text.printWelcome();
        String command = "";

        //A do while loop is used to let the user stay inside the program until he presses 5 which is quit!
        do {
            text.printOptions();
            command = input.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Choose an option" +
                            "\n 1. View all the tasks" +
                            "\n 2. View tasks sorted by date" +
                            "\n 3. View tasks sorted by project");
                    String option = input.nextLine();


                    switch (option) {
                        case "1":
                            if (container.isEmpty()) {
                                System.out.println("You have no tasks at the moment!\n");
                                break;
                            }

                            System.out.println("Your tasks are: ");
                            System.out.println("--------------------");
                            for (Task t : container) {
                                System.out.println(t);
                            }
                            System.out.println("--------------------");
                            break;

                        case "2":
                            if (container.isEmpty()) {
                                System.out.println("You have no tasks at the moment!\n");
                                break;
                            }

                            container.stream()
                                    .sorted(Comparator.comparing(Task::getDate))
                                    .collect(Collectors.toList())
                                    .forEach(x -> System.out.println("#" + container.indexOf(x) + 1 + "\n" + task));
                            break;

                        case "3":
                            if (container.isEmpty()) {
                                System.out.println("You have no tasks at the moment!\n");
                                break;
                            }
                            container.stream()
                                    .sorted(Comparator.comparing(Task::getProject))
                                    .collect(Collectors.toList())
                                    .forEach(System.out::println);
                    }
                    break;

                case "2":

                    String answer = "";
                    do {
                        task = new Task();
                        //new Task();
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



            }
        } while (command != "5");
    }
}
