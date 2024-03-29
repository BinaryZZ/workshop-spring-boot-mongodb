package com.binaryz.workshopmongo.dto;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    @Serial // defines this attribute as Serial
    private static final long SerialVersionUID = 1L;

    private String txt;
    private Date date;
    private AuthorDTO author;

    public CommentDTO(){
    }

    public CommentDTO(String txt, Date date, AuthorDTO author) {
        this.txt = txt;
        this.date = date;
        this.author = author;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }


}
