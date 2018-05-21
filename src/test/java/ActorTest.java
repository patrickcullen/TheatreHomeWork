import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActorTest {

    Actor actor;
    Placement placement;
    Play play;
    Theatre theatre;
    Author author;

    @Before
    public void before(){
        author = new Author("Malcolm Bains");
        theatre = new Theatre("The Citizens", 2000, 25000.00);
        play = new Play("Death of a Car Salesman", author, theatre, 0.00, 0.00, new GregorianCalendar(2018, 2, 2), new GregorianCalendar(2018, 4,1));
        placement = new Placement("Biff", play);
        actor = new Actor("Sean Connery", true, 200.00, placement);
    }

    @Test
    public void canGetName(){
        assertEquals("Sean Connery", actor.getActorName());
    }

    @Test
    public void canGetAvailable(){
        assertTrue(actor.getAvailable());
    }

    @Test
    public void canGetDailyRate(){
        assertEquals(200.00, actor.getDailyRate(),0.01);
    }
}
