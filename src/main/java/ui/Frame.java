package ui;

import javax.swing.*;
import java.awt.*;

public class Frame {
    static void frame() {
        // Создаю основной фрейм
        JFrame frame = new JFrame("Square");
        frame.setSize(500, 600);
        // Создаю панель для размещения кнопок
        JPanel buttonsPanel = new JPanel();

        // Создаю матрицу кнопок, мб чтобы потом их заполнять крестиками и ноликами
        Buttons westNorthButton = new Buttons("0");
        Buttons westButton = new Buttons("0");
        Buttons westSouthButton = new Buttons("0");
        Buttons northButton = new Buttons("0");
        Buttons centerButton = new Buttons("0");
        Buttons southButton = new Buttons("0");
        Buttons eastNorthButton = new Buttons("0");
        Buttons eastButton = new Buttons("0");
        Buttons eastSouthButton = new Buttons("0");

//       Добавляю кнопки в панель
        buttonsPanel.add(westNorthButton);
        buttonsPanel.add(westButton);
        buttonsPanel.add(westSouthButton);
        buttonsPanel.add(northButton);
        buttonsPanel.add(centerButton);
        buttonsPanel.add(southButton);
        buttonsPanel.add(eastNorthButton);
        buttonsPanel.add(eastButton);
        buttonsPanel.add(eastSouthButton);

//      Размещаю панель на фрейме
        frame.getContentPane().add(BorderLayout.WEST, buttonsPanel);

        // making the frame visible
        frame.setVisible(true);
    }
}
