package io.github.jon_bassi.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by jon on 9/22/2016.
 * Singleton class for preloading of necessary resources (images/icons)
 */
public class ResourceLoader
{
    public  ArrayList<Node> iconList16px;
    public  ArrayList<Image> iconList64px;
    public  ObservableList<String> nameList64px;
    private static ResourceLoader instance = new ResourceLoader();


    private ResourceLoader()
    {
        iconList16px = new ArrayList<>();
        iconList64px = new ArrayList<>();
        nameList64px = FXCollections.observableArrayList();
        loadResources();
    }

    public static ResourceLoader getInstance()
    {
        return instance;
    }

    private void loadResources()
    {
        File folder = new File("src/io/github/jon_bassi/resources/icons/16/");
        System.out.println(folder.getAbsolutePath());
        File[] listOfFiles = folder.listFiles();


        // load 16px icons
        String prefix = "../resources/icons/16/";
        for (File f : listOfFiles)
        {
            iconList16px.add(new ImageView(new Image(getClass()
                    .getResourceAsStream(prefix + f.getName()))));
        }

        // load 64px icons
        prefix = "../resources/icons/64/";
        for (File f : listOfFiles)
        {
            iconList64px.add(new Image(getClass().getResourceAsStream(prefix + f.getName())));
            nameList64px.add(f.getName().substring(f.getName().indexOf("-") + 2));
        }
    }
}
