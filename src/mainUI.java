import javax.swing.*;
import java.awt.*;

public class mainUI extends  JFrame{

    private page context;

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

        //Set the listCharacter context
        this.setListCharacterContext();

        //Actually display the window
        this.setVisible(true);
    }

    //Method called when you
    private void emptyWindow() {
        this.getContentPane().removeAll();
    }

    private void setListCharacterContext() {
        this.context = new listCharacterPage();
        this.setContentPane(this.context.getPanel());
    }

}
