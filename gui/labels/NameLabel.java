package rpg.gui.labels;

import rpg.gui.ui.NameLabelUI;

import javax.swing.*;

public class NameLabel extends JLabel {

    public NameLabel(String name) {
        super(name);
        setUI(new NameLabelUI());
    }
}