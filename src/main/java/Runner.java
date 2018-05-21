import db.*;
import models.*;

import javax.management.relation.Role;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Theatre theatre1 = new Theatre("The Apollo", 4000, 40000.00);
        Theatre theatre2 = new Theatre("The Citizens", 2000, 25000.00);

        DBHelper.save(theatre1);
        DBHelper.save(theatre2);

        Author author1 = new Author("Paddy Cullen");
        Author author2 = new Author("Malcolm Bains");
        Author author3 = new Author("Isla Mitchison");

        DBHelper.save(author1);
        DBHelper.save(author2);
        DBHelper.save(author3);

        Play play1 = new Play("Romeo and Morag", author1 , theatre1 ,0.00, 0.00, new GregorianCalendar(2018, 0, 2), new GregorianCalendar(2018, 1,14));
        Play play2 = new Play("Death of a Car Salesman", author2, theatre2, 0.00, 0.00, new GregorianCalendar(2018, 2, 2), new GregorianCalendar(2018, 4,1));
        Play play3 = new Play("Glengarry Glen Campbell", author1, theatre1, 0.00, 0.00, new GregorianCalendar(2018, 1, 15), new GregorianCalendar(2018, 4,15));

        DBHelper.save(play1);
        DBHelper.save(play2);
        DBHelper.save(play3);

        theatre1.addPlay(play1);
        theatre1.addPlay(play3);
        theatre2.addPlay(play2);

        Placement placement1 = new Placement("Romeo", play1);
        Placement placement2 = new Placement("Roma", play3);
        Placement placement3 = new Placement("Levene", play3);
        Placement placement4 = new Placement("Aaronow", play3);
        Placement placement5 = new Placement("Willy", play2);
        Placement placement6 = new Placement("Linda", play2);
        Placement placement7 = new Placement("Moss", play3);
        Placement placement8 = new Placement("Biff", play2);
        Placement placement9 = new Placement("Morag", play1);
        Placement placement10 = new Placement("Blake", play3);

        DBHelper.save(placement1);
        DBHelper.save(placement2);
        DBHelper.save(placement3);
        DBHelper.save(placement4);
        DBHelper.save(placement5);
        DBHelper.save(placement6);
        DBHelper.save(placement7);
        DBHelper.save(placement8);
        DBHelper.save(placement9);
        DBHelper.save(placement10);

        Actor actor1 = new Actor("Sean Connery", true, 200.00, null);
        Actor actor2 = new Actor("Julie Andrews", true, 100.00, null);
        Actor actor3 = new Actor("Judi Dench", true, 100.00, null);
        Actor actor4 = new Actor("Jane Fonda", true, 4.00, null);

        DBHelper.save(actor1);
        DBHelper.save(actor2);
        DBHelper.save(actor3);
        DBHelper.save(actor4);

        play2.addPlacement((placement8));
        play2.addPlacement((placement5));
        play2.addPlacement((placement6));

        actor1.addPlacement(placement8);
        placement8.addActor(actor1);
        actor2.addPlacement(placement5);
        placement5.addActor(actor2);
        actor3.addPlacement(placement6);
        placement6.addActor(actor3);
        actor4.addPlacement(placement10);
        placement10.addActor(actor4);

        theatre2.addPlay(play2);
        author1.addPlay(play2);

        List<Play> singleAuthorList = DBAuthor.findPlaysForAuthor(author1);
        List<Actor> findActorForPlacement = DBPlacement.findActorsForPlacement(placement6);
        List<Placement> findPlacementForActor = DBActor.findPlacementsForActor(actor3);

        List<Placement> singlePlayList = DBPlay.findCharactersForPlay(play2);
        Placement foundPlacement = DBHelper.find(Placement.class, placement8.getId());
        List<Actor> getAllActors = DBHelper.getAll(Actor.class);

        theatre2.setTheatreName("Theatre of Code");
        DBHelper.save(theatre2);
        placement5.setPlacementName("Frank Spencer");
        DBHelper.save(placement5);

        actor4.setPlacement(null);
        actor4.setAvailable(true);
        placement10.setActor(null);
        DBHelper.save(actor4);
        DBHelper.save(placement10);

        DBHelper.delete(actor4);

        DBHelper.save(play2);
        DBHelper.save(actor1);
        DBHelper.save(actor2);
        DBHelper.save(actor3);

        DBHelper.save(placement5);
        DBHelper.save(placement6);
        DBHelper.save(placement8);
        DBHelper.save(theatre2);
        DBHelper.save(author1);
        List<Actor> getFewerActors = DBHelper.getAll(Actor.class);

        double rateHolder = placement8.getActor().getDailyRate();
        double ratesHolder = play2.calculateSalarySum(DBPlay.findCharactersForPlay(play2));

//        actor1.removePlacement(placement8);
//        placement8.removeActor(actor1);
//
//        DBHelper.save(placement8);
//        DBHelper.save(actor1);


    }
}
