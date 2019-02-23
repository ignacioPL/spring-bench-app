package io.perezlaborda.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserEventPk implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "datetime")
    private Long datetime;

    protected UserEventPk(){}

    public UserEventPk(String userId, Long datetime) {
        this.userId = userId;
        this.datetime = datetime;
    }

    public String getUserId() {
        return userId;
    }

    public Long getDatetime() {
        return datetime;
    }

    @Override
    public String toString() {
        return "UserEventPk{" +
                "userId='" + userId + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEventPk that = (UserEventPk) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, datetime);
    }
}
