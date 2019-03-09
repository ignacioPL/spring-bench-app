package io.perezlaborda.models;

public class UserEvent {

    private String countryCode;
    private String data;
    private String userId;
    private Long datetime;

    public UserEvent(String userId, Long datetime, String countryCode, String data) {
        this.userId = userId;
        this.datetime = datetime;
        this.countryCode = countryCode;
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public Long getDatetime() {
        return datetime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "countryCode='" + countryCode + '\'' +
                ", data='" + data + '\'' +
                ", userId='" + userId + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
