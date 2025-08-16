package org.example.serivece;

import org.example.models.VideoGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VideoGameService {

    private List<VideoGame> videoGames;
    private final String filePath;

    public VideoGameService(String filePath) {
        this.videoGames = new ArrayList<>();
        this.filePath = filePath + File.separator + "list.gb";
    }

    private void saveInFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(this.videoGames);
        } catch (IOException e) {
            System.out.println("NO SE PUDO GUARDAR LA LSITA" + e.getMessage());
        }
    }

    private List<VideoGame> returnVideoGames(Object object) {
        if (!(object instanceof List<?>)) {
            return null;
        }
        final List<?> list = (List<?>) object;
        for (Object item : list) {
            if (!(item instanceof VideoGame)) {
                return null;
            }
        }
        return (List<VideoGame>) list;
    }

    private void loadData() {
        final File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
                final Object object = objectInputStream.readObject();
                final List<VideoGame> list = returnVideoGames(object);
                if (list == null) {
                    System.out.println("NO ES UNA LISTA DE VIDEOJUEGOS");
                    return;
                }
                this.videoGames = list;
                System.out.println("SE CARGARON LOS DATOS CORRECTAMENTE");
            } catch (Exception e){
                System.out.println("OCURRIO UN ERROR A LA HORA DE CARGAR DATOS: " + e.getMessage());
            }
        } else {
            System.out.println("EL ARCHIVO DE PERSISTENCIA NO EXISTE");
        }

    }
}
