import models.Author;
import models.Play;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;

public class AuthorTest {

    Author author;
    Play play;

    @Before
    public void before(){
        author = new Author("Paddy Cullen");
        play = new Play("Death of a Car Salesman", author, null, 10.00, 4000.00, new GregorianCalendar(2018, 2, 2), new GregorianCalendar(2018, 4,1));
    }

    @Test
    public void canCountPlays(){
        assertEquals(0, author.countPlays());
    }

    @Test
    public void canAddPlayToAuthor(){
        author.addPlay(play);
        assertEquals(1, author.countPlays());
    }
}
