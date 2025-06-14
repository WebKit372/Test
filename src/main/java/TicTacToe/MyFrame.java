package TicTacToe;

import javax.swing.*;
import java.awt.*;

//public class MyFrame {
//    public static void frame() {
////        Main frame
//        JFrame frame = new JFrame("Square");
////        Setting size for a frame
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
//        MyButton[] buttons = new MyButton[9];
//
//        for(int i = 0; i < 9; i++){
//         buttons[i] = new MyButton(Integer.toString(i));
//         JPanel buttonPanel = new JPanel();
//         buttonPanel.add(buttons[i]);
//         panel.add(buttonPanel);
//        }
//        frame.add(panel);
//        frame.setSize(1000, 1000);
//        frame.setVisible(true);
//    }
//}
class MyFrame extends JFrame {

    public MyFrame(String title) throws HeadlessException {
        super(title);
    }

    public MyFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public MyFrame() throws HeadlessException {
        super();
    }

    public MyFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }
    private void init(int size){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(size,size,2 ,2));
        MyButton[][] buttons = new MyButton[size][size];
        for (int i = 0; i < size; i++ ){
            for (int j = 0; j < size; j++){
                buttons[i][j] = new MyButton(Integer.toString(i) + Integer.toString(j));
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(buttons[i][j]);
                panel.add(buttonPanel);
            }
        }
        this.add(panel);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }
}
