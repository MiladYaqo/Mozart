package Todolist;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * TodoList.Program class.
 * This is where everything happens, (switch) is used to implement user commands, the objects are initialised first.
 * The class takes a user input through the scanner and performs operations, the input is passed through the switch
 * statement that controls which option to be executed.
 *
 * @author MiladYaqo
 */


 public class Program {
    private Text text = new Text();
    private Scanner input = new Scanner(System.in);
    private static List<Task> container = new ArrayList<>();
    private File file = new File("Tasks.txt");


    public Program (){
    }

    /**
     * ReadFromAFile method which reads from a file that is already saved
     *
     */
    void readFromFile(){

        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oInput = new ObjectInputStream(fi);
            try {
                while (true) {

                    Task t = (Task)oInput.readObject();
                    container.add(t);
                }
            } catch (EOFException | ClassNotFoundException | FileNotFoundException ex){ex.printStackTrace();}
        } catch (IOException e){e.printStackTrace();}

    }

    /**
     * WriteToFile
     * A method that writes the created tasks into a file
     */
    void writerToFile(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fos);

            for (Task t: container){
                output.writeObject(t);
            }
            fos.close();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * getContainer
     * A method that returns the "container" list.
     * This method is used in TaskSetter class.
     * @return container.
     */
    static List getContainer() {
        return container;
    }

    static int tasksThatAreDone() {
        int taskDoneCount =0;
        for (Task t: container){
            if(t.getDone().toLowerCase().equals("done")) {
                 taskDoneCount++;
            }
        }
        return taskDoneCount;
    }
    /**
     * run
     * A method that performs the options which uses a do while loop
     * to let the user stay inside the program until he presses 5 which is quit.
     */
    void run() {

        //Printing welcome and initializing (command) as empty so the while loop works.
        text.printWelcome();
        String command;

        System.out.println();

        //A do while loop is used to let the user stay inside the program until he presses 5 which is quit!
        do {
            text.printOptions();
            command = input.nextLine();

            switch (command) {
                //Case one for option 1 which is for printing the existing tasks sorted or unsorted.
                case "1":

                    if (container.isEmpty()) {
                        System.out.println("You have no tasks at the moment!\n");
                        break;
                    }

                    text.sortOptions();

                    String option = input.nextLine();
                    //An inside switch case to prompt the user for the type of sort he/she wants.
                    switch (option) {

                        case "1":
                            System.out.println("Your tasks are:" + "\n--------------------");
                            container.forEach(x -> System.out.println("#" + (container.indexOf(x) + 1) + "\n" + x));
                            break;

                        case "2":
                            System.out.println("Your tasks sorted by date are:" + "\n--------------------");
                            container.stream()
                                    .sorted(Comparator.comparing(Task::getDate))
                                    .collect(Collectors.toList())
                                    .forEach(x -> System.out.println("#" + (container.indexOf(x) + 1) + "\n" + x));
                            break;

                        case "3":
                            System.out.println("Your tasks sorted by project title are:" + "\n--------------------");
                            container.stream()
                                    .sorted(Comparator.comparing(Task::getProject))
                                    .collect(Collectors.toList())
                                    .forEach(x -> System.out.println("#" + (container.indexOf(x) + 1) + "\n" + x));
                            break;

                    }
                    System.out.println("--------------------");
                    break;

                //Case two for option 2 which is to add a task.
                //It uses TaskSetter class to add a task.
                case "2":
                    String answer;
                    do {
                        TaskSetter setter = new TaskSetter();
                        setter.taskSetter();
                        answer = input.nextLine().toLowerCase();

                    } while (answer.equals("y"));
                    break;

                //Case three for option 3 which is to change a task.
                //It uses TaskSetter class to perform the changes in a task.
                case "3":

                    do {
                        if (container.isEmpty()){
                            System.out.println("You have no tasks at the moment!\n");
                            break;
                        }

                        System.out.println("Which task do you want to edit? \n");
                        for (Task t : container) {
                            System.out.println(container.indexOf(t) + 1 + "." + "\n" + t + "\n"); //Or t.getTitle()
                        }

                        TaskSetter setter = new TaskSetter();
                        setter.taskChanger();

                        System.out.println("Do you want to change another task? Y/N");
                        answer = input.nextLine();

                    } while (answer.toLowerCase().equals("y"));
                    break;

                case "4":
                    writerToFile();
                    System.out.println("Tasks successfully saved");
                    break;

            }
        }
        while (!command.equals("5"));
    }
}
