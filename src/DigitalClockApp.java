import javax.swing.*;
import java.awt.*;
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

        JPanel panel = new JPanel(new FlowLayout());

        //Create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.MAGENTA);

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
        add(panel);
        panel.add(timeLabel, SwingConstants.CENTER);

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
//        resizeLabelToFitText();
        timeLabel.setText(time);
    }
    private void resizeLabelToFitText() {
        Font font = timeLabel.getFont();
        FontMetrics fontMetrics = timeLabel.getFontMetrics(font);

        String text = timeLabel.getText();
        int textWidth = fontMetrics.stringWidth(text);
        int labelWidth = timeLabel.getWidth();
        int labelHeight = timeLabel.getHeight();

        //Adjust the font size to fit the label width
        float fontSize = font.getSize() * ((float) labelWidth / textWidth);
        Font newFont = font.deriveFont(fontSize);

        //timeLabel.setFont(newFont);

        //Center the text vertically and horizontally in the label
        int yOffset = (labelHeight - fontMetrics.getHeight()) / 2;
        int xOffset = (labelWidth - fontMetrics.stringWidth(text)) / 2;
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(0, xOffset, 0, 0));
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
