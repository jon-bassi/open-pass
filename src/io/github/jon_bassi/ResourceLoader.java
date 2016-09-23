package io.github.jon_bassi;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by jon on 9/22/2016.
 */
public class ResourceLoader
{
    public final Node folderIcon = new ImageView(
            new Image(getClass().getResourceAsStream("resources/folder_16.png"))
    );
}
