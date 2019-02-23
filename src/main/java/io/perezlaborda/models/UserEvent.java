package io.perezlaborda.models;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "events", schema = "bench")
public class UserEvent {

    @EmbeddedId
    private UserEventPk pk;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "data")
    private String data;

    protected UserEvent(){}

    public UserEvent(UserEventPk pk, String countryCode, String data) {
        this.pk = pk;
        this.countryCode = countryCode;
        this.data = data;
    }

    public UserEventPk getPk() {
        return pk;
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
                "pk=" + pk +
                ", countryCode='" + countryCode + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
