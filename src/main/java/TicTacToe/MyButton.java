package TicTacToe;

import javax.swing.*;
import java.awt.*;


class MyButton extends JButton {
    public MyButton(){
        super();
        buttonInit();
    }
    public MyButton(String text, Icon icon){
        super(text, icon);
        buttonInit();
    }
    public MyButton(String text){
        super(text);
        buttonInit();
    }
    public MyButton(Action a){
        super(a);
        buttonInit();
    }
    public MyButton(Icon icon){
        super(icon);
        buttonInit();
    }
    private void buttonInit(){
        setPreferredSize(new Dimension(250,250));
        addActionListener(e -> action());
    }
    private void action(){
        setEnabled(false);
        setText("Rabotaet");
    }
}
