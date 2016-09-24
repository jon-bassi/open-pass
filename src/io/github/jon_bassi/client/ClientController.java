package io.github.jon_bassi.client;

import io.github.jon_bassi.util.ResourceLoader;
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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jon on 9/22/2016.
 * ClientController class for the HomeView
 */
public class ClientController implements Initializable
{

    @FXML
    public TreeView<String> groupTree;

    @FXML
    public TableView<String> groupTable;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        System.out.println("opening applicaiton...");

        TreeItem<String> rootItem = new TreeItem<>("root");
        rootItem.setExpanded(true);
        for (int i = 0; i < 3; i++)
        {
            TreeItem<String> item = new TreeItem<>("Group " + i, Main.resources.iconList16px.get(40 + i));
            rootItem.getChildren().add(item);
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/io/github/jon_bassi/group/NewGroup.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New Group");
            stage.setScene(new Scene(root));

            stage.setOnHidden(event -> {
                System.out.println("Closing new group...");

                // check for update
                if (Main.context.checkForNewGroup())
                {
                    groupTree.getRoot().getChildren().add(Main.context.getNewGroup());
                    groupTree.refresh();
                }

            });

            stage.show();
        } catch (Exception e)
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
        for (int i = 0; i < groupTree.getRoot().getChildren().size(); i++)
            System.out.println(groupTree.getRoot().getChildren().get(i));

    }
}
