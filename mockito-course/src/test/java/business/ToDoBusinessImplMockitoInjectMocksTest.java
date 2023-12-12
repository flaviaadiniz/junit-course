package business;

import data.ToDoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessImplMockitoInjectMocksTest {

    @Mock
    ToDoService toDoServiceMock; //creates a mock of this kind for the class

    @InjectMocks
    ToDoBusinessImpl toDoBusinessImpl; //creates an instance of ToDoBusinessImpl and injects the instance of
                                       //ToDoService as a dependency

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor; // creates a captor of the type String


    @Test
    public void testRetrieveToDosRelatedToSpring_usingAMock() {
        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(toDoServiceMock.retrieveToDos("Dummy")).thenReturn(toDos);

        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(2, filteredToDos.size());
    }


    @Test
    public void testRetrieveToDosRelatedToSpring_withEmptyList() {
        List<String> toDos = Arrays.asList();

        when(toDoServiceMock.retrieveToDos("Dummy")).thenReturn(toDos);

        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(0, filteredToDos.size());
    }


    @Test
    public void testRetrieveToDosRelatedToSpring_usingBDD() {
        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(toDoServiceMock.retrieveToDos("Dummy")).willReturn(toDos);

        //when
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        //then
        assertEquals(2, filteredToDos.size());
    }


    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD() {
        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(toDoServiceMock.retrieveToDos("Dummy")).willReturn(toDos);

        //when
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        //then
        then(toDoServiceMock).should().deleteTodo("Learn to Dance");
        then(toDoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(toDoServiceMock).should(never()).deleteTodo("Learn Spring");
    }


    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD_argumentCapture() {

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(toDoServiceMock.retrieveToDos("Dummy")).willReturn(toDos);

        //when
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        //then
        then(toDoServiceMock).should().deleteTodo(stringArgumentCaptor.capture()); //capture the argument
        assertEquals(stringArgumentCaptor.getValue(), "Learn to Dance");
    }

}
