import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainUI extends  JFrame{

    private JList list1;
    private JLabel createCharacterLabel;
    private JTextField nameTextField;
    private JList listClass;
    private JButton createCharacterButton;
    private JPanel mainPanel;
    private JLabel ErrorLabel;

    public mainUI() {
        //Creating the main window of the application

        //Setting the title of the window
        this.setTitle("Chroniques oubliés - Character builder");

        //Setting size of the window
        this.setSize(700, 800);

        //Putting the window at the center of the screen
        this.setLocationRelativeTo(null);

        //End the process if we close the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Actually display the window
        this.setVisible(true);
    }

    private void createUIComponents() {
    }

    public void setListCharacterContext() {
        setContentPane(mainPanel);
    }

}
