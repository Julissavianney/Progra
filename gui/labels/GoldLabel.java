package rpg.gui.labels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class GoldLabel extends PortraitLabel {

    public GoldLabel() {
        super();
        initComponents(); // Asegúrate de llamar a initComponents aquí
        setFont(WindowConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        setForeground(Color.BLACK);
        setText("1000"); // Por ejemplo, una cantidad inicial
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Mueve esto después de inicializar icon
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("gold", "images/goldLabel.png");
        icon = ImageCache.getImageIcon("gold");
        setIcon(icon);

        // Asegúrate de que el icono no sea nulo antes de establecer el tamaño preferido
        if (icon != null) {
            setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        } else {
            System.out.println("Error: El icono de oro no se cargó correctamente.");
        }
    }
}