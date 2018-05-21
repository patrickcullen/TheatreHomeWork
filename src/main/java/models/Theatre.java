package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="theatres")
public class Theatre {

    private String theatreName;
    private int attendence;
    private double income;
    private int id;
    private Set<Play> plays;

    public Theatre(String theatreName, int attendence, double income) {
        this.theatreName = theatreName;
        this.attendence = attendence;
        this.income = income;
        this.plays = new HashSet<Play>();
    }

    public Theatre() {
    }

    @Column(name="theatre_name")
    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    @Column(name="attendence")
    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    @Column(name="income")
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "theatre")
    public Set<Play> getPlays() {
        return plays;
    }

    public void setPlays(Set<Play> plays) {
        this.plays = plays;
    }

    public void addPlay(Play play) {
        this.plays.add(play);
    }
}
