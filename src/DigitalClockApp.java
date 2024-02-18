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

        // Create a label to display the time
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.MAGENTA);
        timeLabel.setForeground(Color.BLACK);

        // Create a fancy font from the file BitFont.ttf
        try {
            // Create the font to use and specify the initial size
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Register the font
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/BitFont.ttf"));
            myFont = myFont.deriveFont(Font.PLAIN, 100);
            ge.registerFont(myFont);
            timeLabel.setFont(myFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Add the label to the panel
        add(timeLabel);

        // Add a component listener to listen for frame size changes
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeFont();
            }
        });

        // Update the time regularly
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        // Get the current time
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormat.format(now);

        // Update the label
        timeLabel.setText(time);

        // Resize the font based on the frame size
        resizeFont();
    }

    private void resizeFont() {
        int labelWidth = timeLabel.getWidth();
        int labelHeight = timeLabel.getHeight();

        // Set the font size based on label dimensions
        float fontSize = Math.min(labelWidth, labelHeight) / 2.5f; // Adjust the divisor for desired scaling, by smaller dimension to ensure the text fits
        Font currentFont = timeLabel.getFont();
        Font newFont = currentFont.deriveFont(Font.PLAIN, fontSize);

        // Set the new font to the label
        timeLabel.setFont(newFont);
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