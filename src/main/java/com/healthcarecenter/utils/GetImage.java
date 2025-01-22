package com.healthcarecenter.utils;
import java.net.URL;
import javax.swing.*;

public class GetImage {

    public ImageIcon getImageFromPath(String imagePath) {
        URL imageUrl = GetImage.class.getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            return icon;
        } else {
            JOptionPane.showMessageDialog(null, "Image not found: " + imagePath);
            return null;
        }
    }
}
