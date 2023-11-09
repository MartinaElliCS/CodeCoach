package VideoOnClick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//TODO: improve sizes and positions of the three components
//TODO: implementing the possible responses to user pressing the "yes" button
//TODO: implementing program closure few seconds after opening video link or after the final response to "yes"
public class PromptFrame extends JFrame{
    private JTextArea textArea = new JTextArea("Hello there! Are you doing something?");    //where output text is written in more than one line
    private JButton yesButton;
    private JButton noButton;
    private int yesCounter = 0;

    public PromptFrame(){
        super("Your programming motivational coach");

        //setting Layout Manager
        setLayout(new BorderLayout());

        //setting dimension and position on pc screen
        setSize(800, 500);
        setLocationRelativeTo(null);    //Frame appears at the center of pc screen
        setResizable(false);

        textArea.setFont(new Font("Sanserif", Font.BOLD, 14));

        JPanel yesPanel = new JPanel();
        JPanel noPanel = new JPanel();
        addComponents(yesPanel, noPanel);

        add(textArea, BorderLayout.PAGE_START);
        add(yesPanel, BorderLayout.LINE_START);
        add(noPanel, BorderLayout.LINE_END);

        //setting closure operation and visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addComponents(JPanel panelA, JPanel panelB){
        yesButton = new JButton("Yes");
        yesButton.setPreferredSize(new Dimension(95, 30));
        noButton = new JButton("No");
        noButton.setPreferredSize(new Dimension(95, 30));

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VideoLauncher v = new VideoLauncher();
                try {
                    v.openYoutubeLink();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //the prompt text is changed if the "yes" button is clicked
        //the text depends on the number of times the user has clicked the button
        //PROTOTYPE IMPLEMENTATION
        yesButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(yesCounter == 0)
                    textArea.setText("Is it important?");
                else if(yesCounter == 1)
                    textArea.setText("Is it programming related?");
                else if (yesCounter == 2)
                    textArea.setText("Are you writing code?");
                else
                    textArea.setText("Keep programming then! :D");
                yesCounter++;
            }
        }));

        //adding buttons to JPanels
        panelA.add(yesButton);
        panelB.add(noButton);
    }

}
