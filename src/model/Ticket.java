package model;

public class Ticket {
    private int id;
    private String title = "";
    private String description = "";
    private String assignedTo = "";
    private Status status;
    private Priority priority;

    public Ticket(int id, String title, String description, String assignedTo, Status status, Priority priority){
        setId(id);
        setTitle(title);
        setDescription(description);
        setAssignedTo(assignedTo);
        setStatus(status);
        setPriority(priority);
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
    public Status getStatus(){
        return this.status;
    }
    public Priority getPriority(){
        return this.priority;
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

    public void setStatus(Status status){
        this.status = status;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "title: " + title +
                "\n" + "Description: "
                + description + "\n"
                + "Assigned personel: "
                + assignedTo + "\n"
                + "Status: " + status
                + "\n" + "Priority: "
                + priority;
    }

}
