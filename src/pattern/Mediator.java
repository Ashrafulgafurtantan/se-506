package pattern;

 interface Colleague {
    void land();
}

 class ConcreteColleague1 implements Colleague{
    private MediatorI mediator;
    //runway

    public ConcreteColleague1(MediatorI mediator)
    {
        this.mediator = mediator;
        //mediator.setLandingStatus(true);
    }

    @Override
    public void land()
    {
        System.out.println("Landing permission granted.");
        mediator.setLandingStatus(true);
    }
}
 class ConcreteColleague2 implements Colleague {
    private MediatorI mediator;

    //flight

    public ConcreteColleague2(MediatorI mediator)
    {
        this.mediator = mediator;
    }

    @Override
    public void land() {
        if (mediator.isLandingOk())
        {
            System.out.println("Successfully Landed.");

        }
        else
            System.out.println("Waiting for landing.");
    }

    public void getReady()
    {
        System.out.println("Ready for landing.");
    }
}




 interface MediatorI {
    public void registerRunway(ConcreteColleague1 runway);

    public void registerFlight(ConcreteColleague2 flight);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);

    public void landing();
}
class ConcreteMediator implements MediatorI{
    private ConcreteColleague2 flight;
    private ConcreteColleague1 runway;
    public boolean land;

    @Override
    public void registerRunway(ConcreteColleague1 runway) {
        this.runway = runway ;
    }

    @Override
    public void registerFlight(ConcreteColleague2 flight) {
        this.flight = flight ;
    }

    @Override
    public boolean isLandingOk() {
        return land ;
    }

    @Override
    public void setLandingStatus(boolean status) {
        land = status ;
    }

    @Override
    public void landing() {
        flight.getReady();
        runway.land();
        flight.land();
    }
}
public class Mediator {
    public static void main(String args[])
    {
        MediatorI mediator = new ConcreteMediator();
        ConcreteColleague2 sparrow101 = new ConcreteColleague2(mediator);
        ConcreteColleague1 mainRunway = new ConcreteColleague1(mediator);
        mediator.registerFlight(sparrow101);
        mediator.registerRunway(mainRunway);
        mediator.landing();

    }
}