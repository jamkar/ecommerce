package model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User {

    private long id;
    private String first_name;
    private String last_name;
    private String avatar;

    public User() {
    }

    public User(long id, String first_name, String last_name, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(first_name)
                .append(last_name)
                .append(avatar)
                .hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User))
            return false;

        User that = (User)obj;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(first_name, that.first_name)
                .append(last_name, that.last_name)
                .append(avatar, that.avatar)
                .isEquals();

//        if (that.id != this.id)
//            return false;
//        if (!that.first_name.equals(this.first_name))
//            return false;
//        if (!that.last_name.equals(this.last_name))
//            return false;
//        if (!that.avatar.equals(this.avatar))
//            return false;
//        return true;
    }
}
