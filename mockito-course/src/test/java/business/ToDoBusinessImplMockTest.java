package business;

import data.ToDoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class ToDoBusinessImplMockTest {

    /*
    - Mocking is creating objects that simulate the behavior of real objects. Unlike stubs, mocks can be
    dinamically created from code at runtime.
    - Mocking offers more funcionality than stubbing
    - It's possible to verify method calls and a lot of other things
     */


    @Test
    public void testRetrieveToDosRelatedToSpring_usingAMock() {
        ToDoService toDoServiceMock = mock(ToDoService.class);

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(toDoServiceMock.retrieveToDos("Dummy")).thenReturn(toDos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);

        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(2, filteredToDos.size());
    }


    @Test
    public void testRetrieveToDosRelatedToSpring_withEmptyList() {
        ToDoService toDoServiceMock = mock(ToDoService.class);

        List<String> toDos = Arrays.asList();

        when(toDoServiceMock.retrieveToDos("Dummy")).thenReturn(toDos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);

        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(0, filteredToDos.size());
    }


    @Test
    public void testRetrieveToDosRelatedToSpring_usingBDD() {
        //given
        ToDoService toDoServiceMock = mock(ToDoService.class);

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(toDoServiceMock.retrieveToDos("Dummy")).willReturn(toDos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);

        //when
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        //then
        assertEquals(2, filteredToDos.size());
    }


    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD() {
        //given
        ToDoService toDoServiceMock = mock(ToDoService.class);

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(toDoServiceMock.retrieveToDos("Dummy")).willReturn(toDos);

        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoServiceMock);

        //when
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        //then
        then(toDoServiceMock).should().deleteTodo("Learn to Dance");
        then(toDoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(toDoServiceMock).should(never()).deleteTodo("Learn Spring");
    }


}
