package business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void shouldReturnListSize() {
        //given - set up the scenario
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        //when - the actual method call

        //then - check the asserts
        assertEquals(2, listMock.size());
    }


    @Test
    public void shouldReturnListSizeMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        //the first time it's called, it returns 2. the second time, it returns 3
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }


    @Test
    public void shouldReturnAnItemFromAList() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("in28Minutes");

        assertEquals("in28Minutes", listMock.get(0));
        assertEquals(null, listMock.get(10));
    }


    @Test(expected = RuntimeException.class)
    public void shouldThrowAnException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        listMock.get(0);
    }


}
