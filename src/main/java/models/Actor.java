package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actors")
public class Actor {

    private String actorName;
    Boolean available;
    double dailyRate;
    private Placement placement;
    private int id;

    public Actor(String actorName, Boolean available, double dailyRate, Placement placement) {
        this.actorName = actorName;
        this.available = available;
        this.dailyRate = dailyRate;
        this.placement = placement;
    }

    public Actor() {
    }

    @Column(name="actor_name")
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
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

    public void addPlacement(Placement placement){
        this.available = false;
        this.placement = placement;
    }

    public void removePlacement(Placement placement) {
        this.available = true;
        this.placement = null;
    }

}
