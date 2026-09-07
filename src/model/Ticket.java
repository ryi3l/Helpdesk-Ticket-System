package model;

public class Ticket {
    private int id;
    private String title = "";
    private String description = "";
    private String assignedTo = "";

    public Ticket(int id, String title, String description, String assignedTo){
        setId(id);
        setTitle(title);
        setDescription(description);
        setAssignedTo(assignedTo);
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getAssignedTo(){
        return this.assignedTo;
    }

    public void setId(int id){
        if(id >= 0){
            this.id = id;
        }
        else{
            System.out.println("ID can't be negative!");
        }
    }

    public void setTitle(String title){
        if(!title.isEmpty()){
            this.title = title;
        }
        else{
            System.out.println("Title can't be blank!");
        }
    }

    public void setDescription(String description){
        if(!description.isEmpty()){
            this.description = description;
        }
        else{
            System.out.println("Description can't be blank!");
        }
    }

    public void setAssignedTo(String assignedTo){
        if(!assignedTo.isEmpty()){
            this.assignedTo = assignedTo;
        }
        else{
            System.out.println("IT personnel can't be blank!");
        }
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "title: " + title +
                "\n" + "Description: "
                + description + "\n"
                + "Assigned personel: "
                + assignedTo;
    }

}
