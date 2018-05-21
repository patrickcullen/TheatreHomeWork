package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {

    private String name;
    private int id;
    private Set<Play> plays;

    public Author(String name) {
        this.name = name;
        this.plays = new HashSet<Play>();
    }

    public Author() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @OneToMany(mappedBy = "author")
    public Set<Play> getPlays() {
        return plays;
    }

    public void setPlays(Set<Play> plays) {
        this.plays = plays;
    }

    public void addPlay(Play play) {
        this.plays.add(play);
    }

    public int countPlays(){
        return this.plays.size();
    }
}
