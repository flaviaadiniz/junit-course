package data;

import java.util.List;

// create ToDoServiceStub
// test ToDoBusnessImpl using ToDoServiceStub
public interface ToDoService {

    public List<String> retrieveToDos(String user);

}
