import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class mainUI extends  JFrame{

    private JLabel createCharacterLabel;
    private JTextField nameTextField;
    private JPanel mainPanel;
    private JButton AddCharacterButton;
    private JComboBox RaceSelect;
    private JComboBox ProfileSelect;
    private JSpinner Strspinner;
    private JSpinner Dexspinner;
    private JSpinner Conspinner;
    private JSpinner Intelspinner;
    private JSpinner Wisspinner;
    private JSpinner Chaspinner;
    private JButton createCharacterButton;
    private JComboBox CharacterList;
    private JComboBox PathSelectOne;
    private JComboBox PathSelectTwo;
    private JButton RemoveButton;
    private JLabel LabelMessage;

    //Characters
    private Vector<Character> characters = new Vector<>();
    private Vector<Profile> profiles = new Vector<Profile>();
    private Vector<Race> races = new Vector<Race>();
    private Vector<Path> paths = new Vector<Path>();
    private int character_index = 0;
    private Path pathOneSelected;
    private Path pathTwoSelected;

    //DataManager
    private databaseHandler bdd = new databaseHandler();


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
        this.races = bdd.getRaces();
        this.profiles = bdd.getProfiles();
        this.characters = bdd.getCharacters();
        for (int i = 0; i < this.characters.size(); i++) {
            this.CharacterList.addItem(this.characters.get(i));
        }

        if (characters.size() > 0) {
            character_index = 0;
            bindCharacterToUI(0);
        }

        //Add Character to the list
        AddCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Character new_char = new Character();
                characters.addElement(new_char);
                bindCharacterToUI(characters.size() - 1);
                character_index = characters.size() - 1;
            }
        });

        //Remove Character from the list and the SQL Tables
        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (characters.size() == 0) {
                    return;
                }
                if (bdd.deleteCharacter(characters.get(character_index))) {
                    CharacterList.removeItem(characters.get(character_index));
                    characters.remove(characters.get(character_index));
                    if (characters.size() == 0) {
                        setDefaultUI();
                    }
                    else {
                        character_index = 0;
                        bindCharacterToUI(character_index);
                    }
                }
            }
        });

        //Save selected Character
        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LabelMessage.setText("");
                    boolean tmp = buildCharacter();
                    if (tmp) {
                        bdd.postCharacter(characters.get(character_index));
                        CharacterList.addItem(characters.get(character_index));
                    } else {
                        bdd.putCharacter(characters.get(character_index));
                    }
                } catch (SamePathException ex) {
                    LabelMessage.setText("You can't choose two time the same path");
                }
            }
        });

        //Associate the Paths to the pathSelects
        ProfileSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Profile tmp = (Profile)e.getItem();
                PathSelectOne.removeAllItems();
                pathOneSelected = tmp.getPaths().get(0);
                pathTwoSelected = tmp.getPaths().get(1);
                for (int i = 0; i < tmp.getPaths().size(); i++) {
                    PathSelectOne.addItem(tmp.getPaths().get(i));
                }
                PathSelectTwo.removeAllItems();
                for (int i = 1; i < tmp.getPaths().size(); i++) {
                    PathSelectTwo.addItem(tmp.getPaths().get(i));
                }

            }
        });
        PathSelectOne.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                LabelMessage.setText("");
                pathOneSelected = (Path) e.getItem();
            }
        });

        PathSelectTwo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                LabelMessage.setText("");
                pathTwoSelected = (Path) e.getItem();
            }
        });

        CharacterList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (characters.indexOf((Character) e.getItem()) == -1) {
                    return;
                }
                character_index = characters.indexOf((Character) e.getItem());
                System.out.println(character_index);
                bindCharacterToUI(character_index);
            }
        });
    }

    private void createUIComponents() {
    }

    private void bindCharacterToUI(int index) {
        LabelMessage.setText("");
        this.nameTextField.setText(this.characters.get(index).getName());
        this.Strspinner.setValue(this.characters.get(index).getSet().getStr());
        this.Dexspinner.setValue(this.characters.get(index).getSet().getDex());
        this.Intelspinner.setValue(this.characters.get(index).getSet().getIntel());
        this.Conspinner.setValue(this.characters.get(index).getSet().getCon());
        this.Wisspinner.setValue(this.characters.get(index).getSet().getWis());
        this.Chaspinner.setValue(this.characters.get(index).getSet().getCha());
        this.RaceSelect.removeAllItems();
        this.ProfileSelect.removeAllItems();
        this.PathSelectOne.removeAllItems();
        this.PathSelectTwo.removeAllItems();
        if (this.characters.get(index).getRace() == null) {
            this.PathSelectOne.setEnabled(true);
            this.PathSelectTwo.setEnabled(true);
            this.RaceSelect.setEnabled(true);
            for (int i = 0; i < this.races.size(); i++) {
                this.RaceSelect.addItem(this.races.get(i));
            }
        }
        else {
            this.RaceSelect.setEnabled(false);
            this.PathSelectOne.setEnabled(false);
            this.PathSelectTwo.setEnabled(false);
            this.RaceSelect.addItem(this.characters.get(index).getRace());
        }
        if (this.characters.get(index).getProfile() == null) {
            this.ProfileSelect.setEnabled(true);
            for (int i = 0; i < this.profiles.size(); i++) {
                this.ProfileSelect.addItem(this.profiles.get(i));
            }
        }
        else {
            this.ProfileSelect.setEnabled(false);
            this.ProfileSelect.addItem(this.characters.get(index).getProfile());
        }
        this.refresh();
    }

    private void setDefaultUI() {
        this.nameTextField.setText("");
        this.Strspinner.setValue(10);
        this.Dexspinner.setValue(10);
        this.Intelspinner.setValue(10);
        this.Conspinner.setValue(10);
        this.Wisspinner.setValue(10);
        this.Chaspinner.setValue(10);
        this.RaceSelect.removeAllItems();
        this.ProfileSelect.removeAllItems();
        this.PathSelectOne.removeAllItems();
        this.PathSelectTwo.removeAllItems();
        this.refresh();
    }

    private boolean buildCharacter() throws SamePathException {
        if (pathOneSelected.getId() == pathTwoSelected.getId()) {
            throw new SamePathException();
        }
        boolean created = this.characters.get(character_index).getRace() == null;
        this.characters.get(character_index).setName(this.nameTextField.getText());
        this.characters.get(character_index).setProfile((Profile) this.ProfileSelect.getSelectedItem());
        Vector<Path> tmp_path = new Vector<Path>();
        tmp_path.add(pathOneSelected);
        tmp_path.add(pathTwoSelected);
        this.characters.get(character_index).setPaths(tmp_path);
        this.characters.get(character_index).getSet().setStr((int) this.Strspinner.getValue());
        this.characters.get(character_index).getSet().setDex((int) this.Dexspinner.getValue());
        this.characters.get(character_index).getSet().setIntel((int) this.Intelspinner.getValue());
        this.characters.get(character_index).getSet().setCon((int) this.Conspinner.getValue());
        this.characters.get(character_index).getSet().setWis((int) this.Wisspinner.getValue());
        this.characters.get(character_index).getSet().setCha((int) this.Chaspinner.getValue());
        this.characters.get(character_index).setRace((Race) this.RaceSelect.getSelectedItem());
        return created;
    }

    private void refresh() {
        this.revalidate();
        this.repaint();
    }

    public void setListCharacterContext() {
        this.setContentPane(mainPanel);
        this.pack();
        this.refresh();
    }
}
