package ui;

import javax.swing.*;
import java.awt.*;

public class Frame {
    static void frame() {
        // ������ �������� �����
        JFrame frame = new JFrame("Square");
        frame.setSize(500, 600);
        // ������ ������ ��� ���������� ������
        JPanel buttonsPanel = new JPanel();

        // ������ ������� ������, �� ����� ����� �� ��������� ���������� � ��������
        Buttons westNorthButton = new Buttons("0");
        Buttons westButton = new Buttons("0");
        Buttons westSouthButton = new Buttons("0");
        Buttons northButton = new Buttons("0");
        Buttons centerButton = new Buttons("0");
        Buttons southButton = new Buttons("0");
        Buttons eastNorthButton = new Buttons("0");
        Buttons eastButton = new Buttons("0");
        Buttons eastSouthButton = new Buttons("0");

//       �������� ������ � ������
        buttonsPanel.add(westNorthButton);
        buttonsPanel.add(westButton);
        buttonsPanel.add(westSouthButton);
        buttonsPanel.add(northButton);
        buttonsPanel.add(centerButton);
        buttonsPanel.add(southButton);
        buttonsPanel.add(eastNorthButton);
        buttonsPanel.add(eastButton);
        buttonsPanel.add(eastSouthButton);

//      �������� ������ �� ������
        frame.getContentPane().add(BorderLayout.WEST, buttonsPanel);

        // making the frame visible
        frame.setVisible(true);
    }
}
