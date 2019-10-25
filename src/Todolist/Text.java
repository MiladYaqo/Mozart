package Todolist;

import java.util.ArrayList;
import java.util.List;

/**
 * TodoList.Text class.
 * A class that prints out texts.
 * The class is created for shortening the methods.
 */
public class Text{
     public void printWelcome() {
         System.out.println();
            System.out.println("Welcome to Accomplish!" +
                    "\nUnfinished tasks: " + (Program.getContainer().size()-Program.tasksThatAreDone()) +
                    "\nFinished tasks: " + Program.tasksThatAreDone() +
                    "\nWhat do you want to do?");
        }

        public void printOptions() {
            System.out.println("Pic an option:");
            System.out.println("(1) Show tasks");
            System.out.println("(2) Add a task");
            System.out.println("(3) Edit a task");
            System.out.println("(4) Save");
            System.out.println("(5) quit");
        }

        public void sortOptions(){

            System.out.println("Choose an option" +
                    "\n 1. View all the tasks" +
                    "\n 2. View tasks sorted by date" +
                    "\n 3. View tasks sorted by project");
        }

}