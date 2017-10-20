package ba.instastats.instastats.instaController.Model;

import java.io.Serializable;

public class InstagramExpandedUser extends InstagramBaseUser implements Serializable {

    private String bio;
    private String website;
    private String is_business;
    private Counts counts;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIs_business() {
        return is_business;
    }

    public void setIs_business(String is_business) {
        this.is_business = is_business;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }
}
