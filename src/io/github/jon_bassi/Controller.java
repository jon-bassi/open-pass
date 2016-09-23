package io.github.jon_bassi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jon on 9/22/2016.
 * Controller class for the HomeView
 */
public class Controller implements Initializable
{

    ResourceLoader resources = new ResourceLoader();

    @FXML
    public TreeView<String> groupTree;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        System.out.println("opening applicaiton...");

        TreeItem<String> rootItem = new TreeItem<String>("Inbox",resources.folderIcon);
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++)
        {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }

        groupTree.setRoot(rootItem);
        groupTree.refresh();

    }

}
