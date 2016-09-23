package io.github.jon_bassi.Controllers;

import io.github.jon_bassi.ResourceLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jon on 9/22/2016.
 * MainController class for the HomeView
 */
public class MainController implements Initializable
{

    ResourceLoader resources = new ResourceLoader();

    @FXML
    public TreeView<String> groupTree;

    @FXML
    public TableView<String> groupTable;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        System.out.println("opening applicaiton...");

        TreeItem<String> rootItem = new TreeItem<String>("Inbox",resources.folderIcon);
        rootItem.setExpanded(true);
        for (int i = 1; i < 20; i++)
        {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        for (int i = 1; i < 3; i++)
        {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().get(0).getChildren().add(item);
        }

        groupTree.setRoot(rootItem);
        groupTree.refresh();

    }

    /**
     * Menu Buttons
     */

    @FXML
    public void fileNewGroup()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/io/github/jon_bassi/NewGroup.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New Group");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(Exception e)
        {
            //
        }
    }

    @FXML
    public void fileNewPassword()
    {

    }


    /**
     * GUI Interactions
     */

    @FXML
    public void displayTreeInfo()
    {
        System.out.println("tree menu clicked");
    }


}
