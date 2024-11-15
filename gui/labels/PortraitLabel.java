package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;
import rpg.utils.cache.ImageCache;
import javax.swing.*;
import java.awt.*;

public class PortraitLabel extends JLabel {

    protected ImageIcon icon;

    public PortraitLabel() {
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    public void initComponents() {
        ImageCache.addImage("portrait", "player/portrait.png");
        icon = ImageCache.getImageIcon("portrait");
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        setIcon(icon);
    }
}
