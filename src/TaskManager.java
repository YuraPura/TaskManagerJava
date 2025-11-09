import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount++] = task;
        }
    }

    public void addDeadlineTask(DeadlineTask deadlineTask) {
        addTask(deadlineTask);
    }

    public void addRecurringTask(RecurringTask recurringTask) {
        addTask(recurringTask);
    }

    public void removeTask(Task task) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i] == task) {
                System.arraycopy(tasks, i + 1, tasks, i, taskCount - i - 1);
                tasks[--taskCount] = null;
                return;
            }
        }
    }

    public Task[] viewTasks() {
        Task[] sortedTasks = Arrays.copyOf(tasks, taskCount);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Arrays.sort(sortedTasks, Comparator.comparing(task -> LocalDate.parse(task.getCreatedData(), formatter)));
        return sortedTasks;
    }
}