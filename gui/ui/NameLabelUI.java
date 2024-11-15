package rpg.gui.ui;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NameLabelUI extends GameLabelUI {

    private final BufferedImage[] icons;

    public NameLabelUI() {
        super(null, null);
        icons = new BufferedImage[3];

        // Cargar imágenes desde la caché
        ImageCache.addImage("label_left", "images/label_left.png");
        ImageCache.addImage("label_center", "images/label_center.png");
        ImageCache.addImage("label_right", "images/label_right.png");

        // Convertir imágenes a BufferedImage
        icons[0] = convertToBufferedImage(ImageCache.getImageIcon("label_left"));
        icons[1] = convertToBufferedImage(ImageCache.getImageIcon("label_center"));
        icons[2] = convertToBufferedImage(ImageCache.getImageIcon("label_right"));
    }

    private BufferedImage convertToBufferedImage(ImageIcon icon) {
        if (icon == null || icon.getIconWidth() <= 0 || icon.getIconHeight() <= 0) {
            System.out.println("Error: Icono nulo o con dimensiones no válidas.");
            return null; // Manejo de iconos nulos o con dimensiones no válidas
        }
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        return image;
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setFont(WindowConstants.LABEL_FONT);
        c.setForeground(Color.BLACK);

        int width = 0;
        for (BufferedImage icon : icons) {
            if (icon != null) {
                width += icon.getWidth();
            }
        }
        width += c.getFontMetrics(c.getFont()).stringWidth(c.getText());

        int height = 0;
        for (BufferedImage icon : icons) {
            if (icon != null) {
                height = Math.max(height, icon.getHeight());
            }
        }
        height = Math.max(height, 51); // Altura mínima

        c.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        int textX = 0;

        // Dibuja los iconos
        for (BufferedImage icon : icons) {
            if (icon != null) {
                g.drawImage(icon, textX, 0, null);
                textX += icon.getWidth();
            }
        }

        // Dibuja el texto
        int textY = (Math.max(icons[1] != null ? icons[1].getHeight() : 0, 51) + fm.getAscent()) / 2;
        g.drawString(label.getText(), textX, textY);
    }
}