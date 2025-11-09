public class Task {
    private String title;
    private String description;
    private String createdData;

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public String getCreatedData() {return createdData;}


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedData(String createdData) {
        if (createdData.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {this.createdData = createdData;}
        else {System.out.println("Не, хуйня!");}
         }
}
