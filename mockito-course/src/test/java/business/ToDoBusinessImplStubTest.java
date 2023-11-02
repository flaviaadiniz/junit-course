package business;

import data.ToDoService;
import data.ToDoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToDoBusinessImplStubTest {

    @Test
    public void testRetrieveToDosRelatedToSpring_usingAStub() {
        ToDoService toDoServiceStub = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceStub);
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");
        assertEquals(2, filteredToDos.size());
    }


}
