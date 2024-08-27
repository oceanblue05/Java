import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuntimeRectangleExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        // Panel to draw the rectangle
        CustomPanel panel = new CustomPanel();
        container.add(panel, BorderLayout.CENTER);

        // Panel with input fields and button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        JLabel xLabel = new JLabel("X:");
        JTextField xField = new JTextField();
        JLabel yLabel = new JLabel("Y:");
        JTextField yField = new JTextField();
        JLabel widthLabel = new JLabel("Width:");
        JTextField widthField = new JTextField();
        JLabel heightLabel = new JLabel("Height:");
        JTextField heightField = new JTextField();

        JButton drawButton = new JButton("Draw");

        inputPanel.add(xLabel);
        inputPanel.add(xField);
        inputPanel.add(yLabel);
        inputPanel.add(yField);
        inputPanel.add(widthLabel);
        inputPanel.add(widthField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);
        inputPanel.add(new JLabel()); // Empty cell
        inputPanel.add(drawButton);

        container.add(inputPanel, BorderLayout.SOUTH);

        // Button action to draw the rectangle
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    int width = Integer.parseInt(widthField.getText());
                    int height = Integer.parseInt(heightField.getText());

                    panel.setRectangle(x, y, width, height);
                    panel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        });

        frame.setVisible(true);
    }
}

class CustomPanel extends JPanel {
    private int x = 50;
    private int y = 50;
    private int width = 200;
    private int height = 100;

    public void setRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
}