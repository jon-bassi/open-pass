package io.github.jon_bassi.util;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by jon on 9/22/2016.
 * make into some singleton class which holds references to all loaded resources (images/sounds/etc.)
 */
public class ResourceLoader
{
    public final Node folderIcon = new ImageView(
            new Image(getClass().getResourceAsStream("../resources/icons/16/285658 - blue folder.png"))
    );
}
