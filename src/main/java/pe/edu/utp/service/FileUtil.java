package pe.edu.utp.service;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class FileUtil {
    public static boolean exportResourceFile(String archOrigen, String archDestino){
        boolean ok = true;
        try {
            InputStream src = FileUtil.class.getClassLoader().getResourceAsStream(archOrigen);
            Files.copy(src, Paths.get(archDestino), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ok = false;
        }
        return ok;
    }
    public static Image getImageAsIcon(String imagOrigen){
        Image img = new ImageIcon(FileUtil.class.getClassLoader().getResource(imagOrigen)).getImage();
        return img;
    }
}
