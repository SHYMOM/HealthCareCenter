package com.healthcarecenter.utils;
import java.net.URL;
import javax.swing.*;

public class getImage {

    public ImageIcon getImageFromPath(String imagePath) {
        URL imageUrl = getImage.class.getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            return icon;
        } else {
            JOptionPane.showMessageDialog(null, "Image not found: " + imagePath);
            return null;
        }
    }
}
