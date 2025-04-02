import java.util.Scanner;

public class TaskCLI {
    private Functions functions;
    private Scanner scanner;

    public TaskCLI() {
        this.functions = new Functions();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===== Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task");
            System.out.println("4. List Task");
            System.out.println("5. Exit");
            System.out.print("Chose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    functions.listTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Option, Try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Type the task description: ");
        String description = scanner.nextLine();

        System.out.println("Chose status: 1- TODO, 2- IN_PROGRESS, 3- DONE");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();

        Status status = getStatusFromChoice(statusChoice);

        Task task = new Task(status, description);
        functions.addTask(task);
    }

    private void removeTask() {
        System.out.print("Type the task ID to be removed: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (functions.removeTask(id)) {
            System.out.println("Task removed successfully");
        } else {
            System.out.println("Task don't exists");
        }
    }

    private void updateTask() {
        System.out.print("Type the task ID to be updated: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type a new description: ");
        String newDescription = scanner.nextLine();

        System.out.println("Chose a new status: 1- TODO, 2- IN_PROGRESS, 3- DONE");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();

        Status newStatus = getStatusFromChoice(statusChoice);

        if (functions.updateTask(id, newDescription, newStatus)) {
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Task don't exists");
        }
    }

    private Status getStatusFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Status.TODO;
            case 2 -> Status.INPROGRESS;
            case 3 -> Status.DONE;
            default -> {
                System.out.println("Invalid choice, definindo como TODO.");
                yield Status.TODO;
            }
        };
    }
}