package Components;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

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
}
