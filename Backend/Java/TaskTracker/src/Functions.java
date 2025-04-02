import java.util.ArrayList;
import java.util.List;

public class Functions{

    private List<Task> taskList;

    public Functions() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task){
        taskList.add(task);
        System.out.println("Task add successfully");
    }

    public boolean removeTask(int id){
        return taskList.removeIf(task -> task.getId() == id);
    }

    public boolean updateTask(int id, String newDescription, Status newStatus){
        for(Task task: taskList){
            if(task.getId() == id){
                task.setDescription(newDescription);
                task.setStatus(newStatus);
                System.out.println("Task updated");
                return true;
            }
        }
        return false;
    }

    public void listTasks(){
        if(taskList.isEmpty()){
            System.out.println("Don't have tasks yet");
        }else{
            for(Task task: taskList){
                System.out.println(task);
            }
        }
    }

}
