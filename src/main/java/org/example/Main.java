package org.example;


import TicTacToe.TicTacToe;
import Components.MyFrame;

public class Main {
    public static void main(String[] args){
        TicTacToe game = new TicTacToe(new MyFrame());
        game.fieldMaking(3);
    }

}