import java.awt.*;
import javax.swing.*;
public class ImageCompressor {
    public static ImageIcon compressImage(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}