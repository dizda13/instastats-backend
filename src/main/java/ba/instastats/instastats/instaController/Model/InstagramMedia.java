package ba.instastats.instastats.instaController.Model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

public class InstagramMedia implements Serializable {
    private String id;
    private InstagramBaseUser user;
    private Images images;
    private String created_time;
    private String caption;
    private boolean user_has_liked;
    private int likes;
    private String[] tags;
    private String filter;
    private int comments;
    private String type;
    private String link;
    private Location location;
    private String attribution;
    private String[] users_in_photo;

    public int getLikes() {
        return likes;
    }

    public void setLikes(Counter likes) {
        this.likes = likes.count;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(Counter comments) {
        this.comments = comments.count;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InstagramBaseUser getUser() {
        return user;
    }

    public void setUser(InstagramBaseUser user) {
        this.user = user;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isUser_has_liked() {
        return user_has_liked;
    }

    public void setUser_has_liked(boolean user_has_liked) {
        this.user_has_liked = user_has_liked;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String[] getUsers_in_photo() {
        return users_in_photo;
    }

    public void setUsers_in_photo(String[] users_in_photo) {
        this.users_in_photo = users_in_photo;
    }
}

class Images implements Serializable {
    private Image thumbnail;
    private Image low_resolution;
    private Image standard_resolution;

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image getLow_resolution() {
        return low_resolution;
    }

    public void setLow_resolution(Image low_resolution) {
        this.low_resolution = low_resolution;
    }

    public Image getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(Image standard_resolution) {
        this.standard_resolution = standard_resolution;
    }
}

class Image implements Serializable {
    private int width;
    private int height;
    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class Location implements Serializable {
    private float latitude;
    private float longitude;
    private long id;
    private String street_address;
    private String name;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Counter implements Serializable{
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

