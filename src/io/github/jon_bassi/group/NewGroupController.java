package io.github.jon_bassi.group;

import io.github.jon_bassi.client.Main;
import io.github.jon_bassi.util.ResourceLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jon on 9/23/2016.
 * controller for new group window
 */
public class NewGroupController implements Initializable
{
    @FXML
    public ImageView iconImage;

    @FXML
    public ComboBox<String> iconNameDropdown;

    @FXML
    public TextField groupName;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        System.out.println("new group opened");

        iconImage.setImage(Main.resources.iconList64px.get(0));
        iconNameDropdown.setItems(Main.resources.nameList64px);
        iconNameDropdown.setValue(iconNameDropdown.getItems().get(0));
    }

    @FXML
    public void onComboBoxUpdate()
    {
        iconImage.setImage(Main.resources.iconList64px.get(iconNameDropdown.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    public void onCancel()
    {
        Stage stage = (Stage) iconImage.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onSave()
    {
        Stage stage = (Stage) iconImage.getScene().getWindow();

        if (groupName.getText().equals(""))
        {
            stage.close();
        }

        Main.context.setNewGroup(new TreeItem<>(
                groupName.getText(),
                Main.resources.iconList16px.get(iconNameDropdown.getSelectionModel().getSelectedIndex())
        ));

        stage.close();
    }

}
