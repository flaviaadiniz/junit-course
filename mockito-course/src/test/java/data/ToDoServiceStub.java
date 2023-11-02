package data;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService {

    @Override
    public List<String> retrieveToDos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
