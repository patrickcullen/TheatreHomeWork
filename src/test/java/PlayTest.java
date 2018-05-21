import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class PlayTest {

    Actor actor;
    Placement placement1;
    Placement placement2;
    Placement placement3;
    Set<Placement> placements;

    Play play;
    Theatre theatre;
    Author author;

    @Before
    public void before(){
        author = new Author("Malcolm Bains");
        theatre = new Theatre("The Citizens", 2000, 25000.00);
        play = new Play("Death of a Car Salesman", author, theatre, 0.00, 0.00, new GregorianCalendar(2018, 2, 2), new GregorianCalendar(2018, 4,1));
        placement1 = new Placement("Biff", play);
        placement2 = new Placement("Linda", play);
        placement3 = new Placement("Willy", play);
//        placements= new HashSet<placement1,>();
//        actor = new Actor("Sean Connery", true, 200.00, placements);
    }

    @Test
    public void canGetTitle(){
        assertEquals("Death of a Car Salesman", play.getTitle());
    }

    @Test
    public void canGetAuthor(){
        assertEquals("", play.getAuthor());
    }

//    @Test
//    public void canCalculateSalarySum(){
//        assertEquals(400.00, play.calculateSalarySum(placement));
//    }

}
