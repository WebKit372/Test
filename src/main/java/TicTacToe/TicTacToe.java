package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    MyFrame gameFrame;
    public TicTacToe(MyFrame frameTemplate){
        this.gameFrame = frameTemplate;
    }
    public void fieldMaking(int size){
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(size,size,2 ,2));
        MyButton[][] buttons = new MyButton[size][size];
        for (int i = 0; i < size; i++ ){
            for (int j = 0; j < size; j++){
                buttons[i][j] = new MyButton(Integer.toString(i) + Integer.toString(j));
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(buttons[i][j]);
                panel.add(buttonPanel);
                String text = String.format("Pos" +" " + i+" "+ j);
                buttons[i][j].setButtonAction(new ButtonAction() {
                    @Override
                    public void execute(JButton owner) {
                        owner.setEnabled(false);
                        owner.setText(text);
                    }
                });
            }
        }
        this.gameFrame.add(panel);
//        this.gameFrame.setSize(1000, 1000);
        this.gameFrame.setVisible(true);
        this.gameFrame.pack();
        this.gameFrame.setLocationRelativeTo(null);
        this.loseGame();
    }
    private void loseGame(){
        JOptionPane.showMessageDialog(new Frame(), "Ti loh", "Wat", JOptionPane.PLAIN_MESSAGE);
    }
}
