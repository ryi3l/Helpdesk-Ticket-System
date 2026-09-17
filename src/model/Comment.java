package model;

public class Comment {
    private String author;
    private String text;
    private String timestamp;

    public Comment(String author, String text, String timestamp){
        setAuthor(author);
        setText(text);
        setTimestamp(timestamp);
    }

    public String getAuthor(){
        return this.author;
    }
    public String getText(){
        return this.text;
    }
    public String getTimestamp(){
        return this.timestamp;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "Author: " + author + "\n" + timestamp + "\n" + "Comment: " + text;
    }
}
