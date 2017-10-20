package ba.instastats.instastats.instaController.Model;

import java.io.Serializable;

public class Counts implements Serializable {
    private long media;
    private long follows;
    private long followed_by;

    public long getMedia() {
        return media;
    }

    public void setMedia(long media) {
        this.media = media;
    }

    public long getFollows() {
        return follows;
    }

    public void setFollows(long follows) {
        this.follows = follows;
    }

    public long getFollowed_by() {
        return followed_by;
    }

    public void setFollowed_by(long followed_by) {
        this.followed_by = followed_by;
    }
}
