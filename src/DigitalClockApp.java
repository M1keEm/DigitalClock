import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockApp extends JFrame {
    private final JLabel timeLabel;

    public DigitalClockApp() {
        // Set up the main frame
        setTitle("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Create a label to display the time
        timeLabel = new JLabel("",JLabel.CENTER);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.MAGENTA);

        //Rectangle r = this.getBounds();
        //timeLabel.setBounds(r.x+100, r.y+100, r.width-200, r.height-200);

        //Create a fancy font from the file BitFont.ttf
        try {
            //Create the font to use and specify the size
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //Register the font
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, new File("BitFont.ttf"));
            myFont = myFont.deriveFont(Font.PLAIN, 100);
            ge.registerFont(myFont);
            timeLabel.setFont(myFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        //Add the label to the panel
        add(timeLabel);

        //Update the time regularly
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        //Get the current time
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormat.format(now);
        //Update the label
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClockApp app = new DigitalClockApp();
            app.setVisible(true);
            app.setPreferredSize(new Dimension(800, 300));
            app.pack();
        });
    }
}
