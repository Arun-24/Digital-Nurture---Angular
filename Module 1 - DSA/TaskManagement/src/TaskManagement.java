class Task {
    int taskId;
    String taskName;
    String status;

    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

public class TaskManagement {

    Task head;

    void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
            return;
        }
        Task temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newTask;
    }

    void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskName);
            temp = temp.next;
        }
    }

    Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    void delete(int id) {
        if (head == null)
            return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;
        while (temp.next != null &&
                temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }
    public static void main(String[] args) {

        TaskManagement tm =
                new TaskManagement();

        tm.addTask(1, "Design UI", "Pending");

        tm.addTask(2, "Develop Backend", "In Progress");

        tm.addTask(3, "Testing", "Pending");

        System.out.println("All Tasks:");

        tm.traverse();

        System.out.println("\nSearching Task 2:");

        Task task = tm.search(2);

        if (task != null) {
            System.out.println(task.taskName + " - " + task.status);
        }

        System.out.println("\nDeleting Task 2");

        tm.delete(2);

        System.out.println("\nTasks After Deletion:");

        tm.traverse();
    }
}