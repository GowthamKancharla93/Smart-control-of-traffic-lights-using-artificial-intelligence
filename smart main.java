import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TrafficLightControl extends JFrame implements ActionListener {

    private static final String TITLE = "Smart Control of Traffic Light Using Artificial Intelligence";
    private static final int WIDTH = 1300;
    private static final int HEIGHT = 1200;
    private static final Font FONT = new Font("Times New Roman", Font.BOLD, 16);
    private static final Font FONT1 = new Font("Times New Roman", Font.BOLD, 14);
    private static final Font TEXT_FONT = new Font("Times New Roman", Font.BOLD, 12);
    private String filename;
    private JTextArea textArea;

    public TrafficLightControl() {
        super(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Smart Control of Traffic Light Using Artificial Intelligence");
        titleLabel.setFont(FONT);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_CYAN);
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setBounds(0, 5, 120 * 11, 3 * 20); // Adjusted for larger font size
        this.getContentPane().add(titleLabel);

        // Run Traffic Simulation button
        JButton simulationButton = new JButton("Run Traffic Simulation");
        simulationButton.setFont(FONT1);
        simulationButton.addActionListener(this);
        simulationButton.setBounds(50, 100, 300, 40);
        this.getContentPane().add(simulationButton);

        // Path label
        JLabel pathLabel = new JLabel();
        pathLabel.setFont(FONT1);
        pathLabel.setOpaque(true);
        pathLabel.setBackground(Color.LIGHT_CYAN);
        pathLabel.setForeground(Color.MAGENTA);
        pathLabel.setBounds(460, 100, 800, 40); // Adjusted width
        this.getContentPane().add(pathLabel);

        // Run Yolo Traffic Detection button
        JButton yoloButton = new JButton("Run Yolo Traffic Detection & Counting");
        yoloButton.setFont(FONT1);
        yoloButton.addActionListener(this);
        yoloButton.setBounds(50, 150, 400, 40);
        this.getContentPane().add(yoloButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(FONT1);
        exitButton.addActionListener(this);
        exitButton.setBounds(460, 150, 100, 40);
        this.getContentPane().add(exitButton);

        // Text area
        textArea = new JTextArea(20, 150);
        textArea.setFont(TEXT_FONT);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 250, WIDTH - 30, HEIGHT - 350); // Adjusted size
        this.getContentPane().add(scrollPane);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Run Traffic Simulation")) {
                runSimulation();
            } else if (button.getText().equals("Run Yolo Traffic Detection & Counting")) {
                yoloTrafficDetection();
            } else if (button.getText().equals("Exit")) {
                System.exit(0);
            }
        }
    }

private void yoloTrafficDetection() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "mp4", "avi");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filename = fileChooser.getSelectedFile().getAbsolutePath();
            updatePathLabel(filename);
            textArea.append(filename + " loaded\n");
            // Replace this with your actual Yolo implementation using filename