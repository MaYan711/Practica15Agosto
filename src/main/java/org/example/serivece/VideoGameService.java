package org.example.serivece;

import org.example.models.VideoGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class VideoGameService {

    private List<VideoGame> videoGames;
    private final String filePath;

    public VideoGameService(String filePath) {

        this,videoGames new ArrayList<VideoGame>();
        this filePath = filePath + File.separator + "list.kl";



    }
    private void saveInFile(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new File)){
            objectOutputStream
        }
    }

    private List<VideoGame> readFromFile(){}
    private void loadData(){
        final File file = new File(filePath);
        if (!file.exists()){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new File())){}
        }
    }
}
