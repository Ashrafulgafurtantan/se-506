package pattern;

interface MobileAlertState
{
    void alert();
}

class AlertStateContext
{
    private MobileAlertState currentState;

    public AlertStateContext()
    {
        currentState = new Vibration();
    }

    public void setState(MobileAlertState state)
    {
        currentState = state;
    }

    public void alert()
    {
        currentState.alert();
    }
}

class Vibration implements MobileAlertState
{
    @Override
    public void alert()
    {
        System.out.println("vibration...");
    }

}

class Silent implements MobileAlertState
{
    @Override
    public void alert()
    {
        System.out.println("silent...");
    }

}

class State
{
    public static void main(String[] args)
    {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Vibration());
        stateContext.alert();
    }
}