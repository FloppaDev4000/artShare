package tools;

import javax.swing.*;
import java.awt.*;

public class ImageTools
{
    public static ImageIcon resize(ImageIcon original, int maxWidth, int maxHeight)
    {

        // Get the original image
        Image image = original.getImage();
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        // Calculate the scaling factor
        double widthRatio = (double) maxWidth / originalWidth;
        double heightRatio = (double) maxHeight / originalHeight;

        // Use the smaller ratio to ensure the image fits within the max dimensions
        double ratio = Math.min(widthRatio, heightRatio);

        // Calculate the new dimensions while maintaining the aspect ratio
        int newWidth = (int) (originalWidth * ratio);
        int newHeight = (int) (originalHeight * ratio);

        // Resize the image to the new dimensions
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);

        // Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        return resizedIcon;
    }

    public static Image resize(Image original, int maxWidth, int maxHeight)
    {

        int originalWidth = original.getWidth(null);
        int originalHeight = original.getHeight(null);

        // Calculate the scaling factor
        double widthRatio = (double) maxWidth / originalWidth;
        double heightRatio = (double) maxHeight / originalHeight;

        // Use the smaller ratio to ensure the image fits within the max dimensions
        double ratio = Math.min(widthRatio, heightRatio);

        // Calculate the new dimensions while maintaining the aspect ratio
        int newWidth = (int) (originalWidth * ratio);
        int newHeight = (int) (originalHeight * ratio);

        // Resize the image to the new dimensions
        Image resizedImage = original.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        return resizedImage;
    }
}
