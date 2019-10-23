import Todolist.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
    Task task = new Task();

    @Test
    public void titleTest(){

        task.setTitle("buy");
        assertEquals("buy", task.getTitle());
    }

    @Test
    public void descriptionTest(){
        task.setDescription("Desc");
        assertEquals("Desc", task.getDescription());
    }

    @Test
    public void projectTest(){
        task.setProject("Project");
        assertEquals("Project", task.getProject());
    }

    @Test
    public void isDoneTest(){
        task.setDone("Done");
        assertEquals("Done", task.getDone());
    }

    @Test
    public void setDateTest(){
        task.setDate("02-02-2012");
        assertEquals("2012-02-02", task.getDate().toString());
    }
}
