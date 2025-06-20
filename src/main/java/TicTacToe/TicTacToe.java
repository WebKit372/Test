package TicTacToe;

import Components.ButtonAction;
import Components.DialogWindow;
import Components.MyButton;
import Components.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
//    Making HashMap where X is 2, O is 1, nullable is 0;
    HashMap<Integer, HashMap<Integer, Integer>> rowValue;
    int size;
    boolean isXTurn = true;
    MyFrame gameFrame;
    public TicTacToe(MyFrame frameTemplate){
        this.gameFrame = frameTemplate;
    }

    public void fieldMaking(int size){
        this.rowValue = new HashMap<>();
        this.size = size;
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(size,size,2 ,2));
        MyButton[][] buttons = new MyButton[size][size];
        for (int i = 0; i < size; i++ ) {
            HashMap<Integer, Integer> cellsValue = new HashMap<>();
            for (int j = 0; j < size; j++) {
//                Filling HashMap cells with values
                cellsValue.put(j, 0);
                buttons[i][j] = new MyButton("");
//              Transfer position value into button
                buttons[i][j].setXPos(i);
                buttons[i][j].setYPos(j);
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(buttons[i][j]);
                panel.add(buttonPanel);
                buttons[i][j].setButtonAction(new ButtonAction() {
                    @Override
                    public void execute(MyButton owner) {
                        owner.setEnabled(false);
                        if (TicTacToe.this.isXTurn) {
                            owner.setText("X");
                        } else {
                            owner.setText("0");
                        }
                        TicTacToe.this.makeTurn(owner.getxPos(), owner.getyPos());
                    }
                });
            }
            this.rowValue.put(i, cellsValue);
        }
        this.gameFrame.add(panel);
        this.gameFrame.setVisible(true);
        this.gameFrame.pack();
        this.gameFrame.setLocationRelativeTo(null);
    }
    private void makeTurn(int xPos, int yPos){
//        System.out.println(xPos);
//        System.out.println(this.rowValue.get(xPos));
        if(this.isXTurn){
            this.rowValue.get(xPos).put(yPos,2);
        }
        else {
            this.rowValue.get(xPos).put(yPos,1);
        }
        this.isXTurn = !this.isXTurn;
        for(Map.Entry<Integer,HashMap<Integer,Integer>> entry: this.rowValue.entrySet()){
//            System.out.println(entry);
        }
//        System.out.println(winCheck(true));
        if(!winCheck(true)){
            winGame(true);
        }
        if(!winCheck(false)){
            winGame(false);
        }
    }

    private void winGame(Boolean isX){
        String text = isX?"Win X": "Win O";
        DialogWindow window = new DialogWindow() {
            @Override
            public void showMessage(String messageText, String windowText) {
                JOptionPane.showMessageDialog(new Frame(), messageText, windowText, JOptionPane.PLAIN_MESSAGE);
            }
        };
        window.showMessage(text, "Attention");
    }

// Checking winning condition for X|O side
    private boolean winCheck(Boolean isX){
        int num = isX?2:1;
        Boolean[] resultOfChecking = new Boolean[(this.size + this.size) + 2];
//        Check row winning scenario
        for (int i = 0; i < this.size; i++){
            resultOfChecking[i] = AdditionalLogic.<Integer>arrayCheck(this.rowValue.get(i).values().toArray(new Integer[this.size]), this.size, new Every<Integer>() {
                @Override
                public boolean execute(Integer component) {
                    return component == num;
                }
            });
//            Checking column winning scenario
            Integer[] arrayOfY = new Integer[this.size];
            for (int j =0; j < this.size; j++){
                arrayOfY[j] = this.rowValue.get(j).get(i);
            }
            resultOfChecking[this.size+i] = AdditionalLogic.<Integer>arrayCheck(arrayOfY, this.size, new Every<Integer>() {
                @Override
                public boolean execute(Integer component) {
                    return component == num;
                }
            });
        }
//        Checking diagonal winning scenario
        for (int i = 0; i < 2; i++){
            Integer[] arrayDiag = new Integer[this.size];
            for (int j =0; j < this.size; j ++) {
                arrayDiag[j] = this.rowValue.get(j).get(j);
            };
            resultOfChecking[(this.size + this.size)+i] = AdditionalLogic.<Integer>arrayCheck(arrayDiag, this.size, new Every<Integer>() {
                @Override
                public boolean execute(Integer component) {
                    return component == num;
                }
            });
        }
//        Check winning by 3 different scenarios
        return AdditionalLogic.<Boolean>arrayCheck(resultOfChecking, ((this.size + this.size) + 2) , new Every<Boolean>() {
            @Override
            public boolean execute(Boolean component) {
                return !component;
            }
        });

    }
}
