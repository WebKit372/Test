package org.example;


import ui.MyFrame;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Tic Tac Toe");
        frame.init(3);
    }
}