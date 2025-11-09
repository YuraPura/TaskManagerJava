import java.time.LocalDate;

public class DeadlineTask extends Task {
    private String deadlineData;

    public String getDeadlineData() {
        return deadlineData;
    }

    public void setDeadlineData(String deadlineData) {
        this.deadlineData = deadlineData;
    }
}
