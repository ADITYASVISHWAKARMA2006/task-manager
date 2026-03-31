import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        int idCounter = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Task Manager 🚀");

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. mark the task as done");
            System.out.println("5. Show Completed Tasks");
            System.out.println("6. Show Pending Tasks");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter task: ");
                String taskName = sc.nextLine();
                Task task = new Task(idCounter++, taskName);
                tasks.add(task);
                System.out.println("Task added!");
            } 
            else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    for (Task t : tasks) {
                        String status = t.isCompleted ? "DONE" : "PENDING";
                        System.out.println(t.id + ". " + t.name + " [" + status + "]");
                    }
                }
            }
                
            else if (choice == 3) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                    continue;
                }
                System.out.print("Enter task ID to delete: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Task t : tasks) {
                    if (t.id == id) {
                        tasks.remove(t);
                        System.out.println("Task deleted!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Task not found.");
                }
            }
            else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            }
            else if (choice == 4) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                    continue;
                }
                System.out.print("Enter task ID to mark completed: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Task t : tasks) {
                    if (t.id == id) {
                        t.isCompleted = true;
                        System.out.println("Task marked as completed!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Task not found.");
                }
            }
            else if (choice == 5) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                    continue;
                }
                if (tasks.stream().noneMatch(t -> t.isCompleted)) {
                    System.out.println("No completed tasks.");
                } else {
                    tasks.stream()
                    .filter(t -> t.isCompleted)
                    .forEach(t -> System.out.println(t.id + ". " + t.name + " [DONE]"));
                }
            }
            else if (choice == 6) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                    continue;
                }
                if (tasks.stream().noneMatch(t -> !t.isCompleted)) {
                    System.out.println("No pending tasks.");
                } else {
                    tasks.stream()
                    .filter(t -> !t.isCompleted)
                    .forEach(t -> System.out.println(t.id + ". " + t.name + " [PENDING]"));
                }
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}