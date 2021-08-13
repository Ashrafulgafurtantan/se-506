package pattern;

class TextWindow{
    private StringBuilder currentText;
    public TextWindow(){
        this.currentText = new StringBuilder();
    }
    public void addText(String text){
        currentText.append(text);
    }
    public String getText(){
        return  currentText.toString();
    }
    public TextWindowState save(){
        return new TextWindowState(currentText.toString());
    }
    public void restore(TextWindowState save){
        currentText = new StringBuilder(save.getText());
    }
}
class TextEditor{
    private TextWindow textWindow;
    private  TextWindowState savedTextWindow;

    public TextEditor(TextWindow t){
        textWindow = t;
    }
    public void hitSave(){
        savedTextWindow = textWindow.save();
    }
    public void hitUndo(){
        textWindow.restore(savedTextWindow);
    }
    public void write(String s){
        textWindow.addText(s);
    }
    public String print(){
        return textWindow.getText();
    }

}
class TextWindowState{
    private String text;
    public TextWindowState(String t){
        text = t;
    }
    public String getText(){
        return text;
    }
}
public class Memento {
    public static void main(String[] args){
        TextEditor textEditor = new TextEditor(new TextWindow());
        textEditor.write("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.\n");
        textEditor.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n");
        textEditor.hitSave();
        textEditor.write("This line is going to be undone.\n");
        System.out.println(textEditor.print());
        textEditor.hitUndo();
        System.out.println(textEditor.print());
    }
}
