package ba.instastats.instastats.instaController.Model;

import java.io.Serializable;

public class Comment implements Serializable {

    String id;
    InstagramBaseUser from;
    String text;
    String created_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InstagramBaseUser getFrom() {
        return from;
    }

    public void setFrom(InstagramBaseUser from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }
}
