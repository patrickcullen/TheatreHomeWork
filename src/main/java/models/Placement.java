package models;

import javax.persistence.*;

@Entity
@Table(name="placements")
public class Placement {

    private String placementName;
    private Play play;
    private Actor actor;
    private int id;


    public Placement(String placementName, Play play) {
        this.placementName = placementName;
        this.play = play;
        this.actor = actor;
    }

    public Placement() {

    }

    @Column(name="placement_name")
    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }

    @ManyToOne
    @JoinColumn(name="play_id", nullable = false)
    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    @OneToOne(mappedBy = "placement", cascade = CascadeType.PERSIST)
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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

    public void addActor(Actor actor) {
//        this.actor.addPlacement();
        this.actor = actor;
    }

    public void removeActor(Actor actor) {
        this.actor = null;
    }

}
