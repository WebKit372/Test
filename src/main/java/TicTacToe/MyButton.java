package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class  MyButton extends JButton {
    private ButtonAction buttonAction;
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
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action();
            }
        });
    }
    public void setButtonAction(ButtonAction buttonAction){
        this.buttonAction = buttonAction;
    }
    private void action(){
        buttonAction.execute(this);
    }
}
