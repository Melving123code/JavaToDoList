import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        this.isComplete = true;
    }
}

class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void removeCompletedTasks() {
        tasks.removeIf(Task::isComplete);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " ["
                        + (task.isComplete() ? "Completed" : "Incomplete") + "]");
            }
        }
    }
}

public class ToDoApp {
    private static ToDoList toDoList = new ToDoList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Mark Task Complete\n4. Remove Completed Tasks\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    toDoList.removeCompletedTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        toDoList.addTask(description);
    }

    private static void markTaskComplete() {
        System.out.print("Enter task number to mark complete: ");
        int taskNumber = scanner.nextInt();
        toDoList.markTaskComplete(taskNumber - 1);
    }
}
