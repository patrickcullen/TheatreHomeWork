package models;

import sun.util.calendar.Gregorian;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="plays")
public class Play {

    private String title;
    private Author author;
    private Theatre theatre;
    private double ticketPrice;
    private double performanceCost;
    private GregorianCalendar startdate;
    private GregorianCalendar enddate;
    private int id;
    private Set<Placement> placements;

    public Play(String title, Author author, Theatre theatre, double ticketPrice, double performanceCost, GregorianCalendar startdate, GregorianCalendar enddate) {
        this.title = title;
        this.author = author;
        this.theatre = theatre;
        this.ticketPrice = ticketPrice;
        this.performanceCost = performanceCost;
        this.startdate = startdate;
        this.enddate = enddate;
        this.placements = new HashSet<Placement>();
    }

    public Play() {
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name="theatre_id", nullable = false)
    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Column(name="ticket_price")
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Column(name="performance_cost")
    public double getPerformanceCost() {
        return performanceCost;
    }

    public void setPerformanceCost(double performanceCost) {
        this.performanceCost = performanceCost;
    }

    @Column(name="start_date")
    public GregorianCalendar getStartdate() {
        return startdate;
    }

    public void setStartdate(GregorianCalendar startdate) {
        this.startdate = startdate;
    }

    @Column(name="end_date")
    public GregorianCalendar getEnddate() {
        return enddate;
    }

    public void setEnddate(GregorianCalendar enddate) {
        this.enddate = enddate;
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

    @OneToMany(mappedBy = "play")
    @Column(name="placements")
    public Set<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(Set<Placement> placements) {
        this.placements = placements;
    }

    public void addPlacement(Placement placement) {
        this.placements.add(placement);
    }

    public int calculateSalarySum(List<Placement> placements){
        int calcTotal = 0;
        for (Placement placement : placements){
            calcTotal += placement.getActor().getDailyRate();
        }
        return calcTotal;
    }


}
