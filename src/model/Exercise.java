package model;

public class Exercise {
    private String title;
    private String description;
    private String category;
    private String owner;

    public Exercise(String title, String description, String category, String owner) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getOwner() {
        return owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    
    
    
    
}
