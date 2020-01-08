import javax.swing.*;
import java.awt.*;

public class SimpleFrameDemo {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private final static int DEFAULT_WIDTH = 300;
    private final static int DEFAULT_LENGTH = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);
    }
}
