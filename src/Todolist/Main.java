package Todolist;

/**
 * TodoList.Main class.
 * The main class where you open a file and read it.
 * Then run the program
 * Finally save the new tasks before termination.
 *
 * @author MiladYaqo.
 */
public class Main{


    public static void main (String [] args) {

        Program program = new Program();

        program.readFromFile();

        program.run();

        System.out.println("See you later!");
        program.writerToFile();

    }
}
