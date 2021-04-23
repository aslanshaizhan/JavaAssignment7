package model;

import java.io.Serializable;

public class CommentBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String login;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
