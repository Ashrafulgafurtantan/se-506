package pattern;
interface Button{
    void print();
}
interface CheckBox{
    void print();
}
class WindowsButton implements Button{

    @Override
    public void print() {
        System.out.println("Windows Button");
    }
}
class WindowsCheckBox implements CheckBox{

    @Override
    public void print() {
        System.out.println("Windows CheckBox");
    }
}
class MacButton implements Button{

    @Override
    public void print() {
        System.out.println("Mac Button");
    }
}
class MacCheckBox implements CheckBox{

    @Override
    public void print() {
        System.out.println("Mac CheckBox");
    }
}
interface OsFactory{
    Button createButton();
    CheckBox createCheckBox();
}
class WindowsFactory implements OsFactory{

    @Override
    public Button createButton() { return new WindowsButton(); }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
class MacFactory implements OsFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

class Application{
    private Button button;
    private CheckBox checkBox;
    Application(OsFactory osFactory){
        button = osFactory.createButton();
        checkBox = osFactory.createCheckBox();
    }

    void print(){
        button.print();
        checkBox.print();
    }
}
public class AbstructFactory {
    private static Application configureApplication(){
        Application app;
        OsFactory osFactory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            osFactory = new MacFactory();
        }else {
            osFactory = new WindowsFactory();
        }
        app = new Application(osFactory);
        return app;
    }
    public static void main(String[] args){
        Application app = configureApplication();
        app.print();
    }
}
