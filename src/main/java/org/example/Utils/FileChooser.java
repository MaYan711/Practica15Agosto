package org.example.Utils;

import javax.swing.*;
import java.io.File;

public class FileChooser {
    private final static JFileChooser fileChooser = new JFileChooser();

    static {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("SELECCIONA LA CARPETA");
    }

    public static String selectPath(String title) {
        final int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            final File file = fileChooser.getSelectedFile();
            final String path = file.getAbsolutePath();
            System.out.println("SELECCION DE LA CARPETA: " + path);
            return path;
        } else {
            System.out.println("ACCION CANCELADA");
            return null;
        }
    }
}
