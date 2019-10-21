package Todolist;


public class Main{


    public static void main (String [] args) {

        Program program = new Program();

        program.readFromFile();

        program.run();

        System.out.println("See you later!");
        program.writerToFile();

    }
}
