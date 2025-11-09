import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1 - Добавить обычную задачу");
            System.out.println("2 - Добавить задачу с дедлайном");
            System.out.println("3 - Добавить повторяющуюся задачу");
            System.out.println("4 - Удалить задачу (по индексу)");
            System.out.println("5 - Просмотреть задачи");
            System.out.println("0 - Выход");
            System.out.print("---> ");

            int choice = scan.nextInt();
            scan.nextLine(); // Очистка буфера

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Введите заголовок:");
                    String title = scan.nextLine();
                    System.out.println("Введите описание:");
                    String desc = scan.nextLine();
                    System.out.println("Введите дату создания (dd.MM.yyyy):");
                    String created = scan.nextLine();
                    Task task = new Task();
                    task.setTitle(title);
                    task.setDescription(desc);
                    task.setCreatedData(created);
                    manager.addTask(task);
                }
                case 2 -> {
                    System.out.println("Введите заголовок:");
                    String title = scan.nextLine();
                    System.out.println("Введите описание:");
                    String desc = scan.nextLine();
                    System.out.println("Введите дату создания (dd.MM.yyyy):");
                    String created = scan.nextLine();
                    System.out.println("Введите дедлайн:");
                    String deadline = scan.nextLine();
                    DeadlineTask dTask = new DeadlineTask();
                    dTask.setTitle(title);
                    dTask.setDescription(desc);
                    dTask.setCreatedData(created);
                    dTask.setDeadlineData(deadline);
                    manager.addDeadlineTask(dTask);
                }
                case 3 -> {
                    System.out.println("Введите заголовок:");
                    String title = scan.nextLine();
                    System.out.println("Введите описание:");
                    String desc = scan.nextLine();
                    System.out.println("Введите дату создания (dd.MM.yyyy):");
                    String created = scan.nextLine();
                    System.out.println("Введите дату старта:");
                    String start = scan.nextLine();
                    System.out.println("Введите интервал (цыфару):");
                    byte interval = scan.nextByte();
                    scan.nextLine();
                    RecurringTask rTask = new RecurringTask();
                    rTask.setTitle(title);
                    rTask.setDescription(desc);
                    rTask.setCreatedData(created);
                    rTask.setDataStart(start);
                    rTask.setIsnterval(interval);
                    manager.addRecurringTask(rTask);
                }
                case 4 -> {
                    System.out.println("Введите индекс задачи для удаления:");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Task[] tasks = manager.viewTasks();
                    if (index >= 0 && index < tasks.length) {
                        manager.removeTask(tasks[index]);
                    } else {
                        System.out.println("Неверный индекс");
                    }
                }
                case 5 -> {
                    Task[] tasks = manager.viewTasks();
                    for (int i = 0; i < tasks.length; i++) {
                        Task t = tasks[i];
                        System.out.println(i + ": " + t.getTitle() + " (" + t.getCreatedData() + ")");
                        System.out.println("Описание: " + t.getDescription());
                        if (t instanceof DeadlineTask) {
                            System.out.println("Дедлайн: " + ((DeadlineTask) t).getDeadlineData());
                        } else if (t instanceof RecurringTask) {
                            System.out.println("Старт: " + ((RecurringTask) t).getDataStart());
                            System.out.println("Интервал: " + ((RecurringTask) t).getIsnterval());
                        }
                        System.out.println("------------------------");
                    }
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}