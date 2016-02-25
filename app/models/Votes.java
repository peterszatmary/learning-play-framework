package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nue on 1.9.2015.
 */
public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // v mongo db moze byt iba AUTO, TABLE nepodporovane
    @Column(name="ID")
    private String id; // v mongo db tuna musi byt string

    @Column(name="timeFrom")
    private Date timeFrom;

    @Column(name="timeTo")
    private Date timeTo;

    @Column(name="timeAdded")
    private Date timeAdded;


    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Votes{" +
                "id='" + id + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", timeAdded=" + timeAdded +
                '}';
    }
}
