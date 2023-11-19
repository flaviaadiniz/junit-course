package business;

import data.ToDoService;

import java.util.ArrayList;
import java.util.List;

//ToDoBusinessImpl - SUT (system under test)
//ToDoService - dependency

public class ToDoBusinessImpl {

    private ToDoService toDoService;


    public ToDoBusinessImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    public List<String> retrieveToDosRelatedToSpring(String user) {
        List<String> filterToDos = new ArrayList<String>();
        List<String> toDos = toDoService.retrieveToDos(user);

        for (String todo : toDos) {
            if (todo.contains("Spring")) {
                filterToDos.add(todo);
            }
        }

        return filterToDos;
    }


    //deletes everything not related to Spring
    public void deleteToDosNotRelatedToSpring(String user) {
        List<String> toDos = toDoService.retrieveToDos(user);
        for (String todo : toDos) {
            if (todo.contains("Spring")) {
                toDoService.deleteTodo(todo);
            }
        }
    }

}
