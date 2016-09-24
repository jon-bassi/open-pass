package io.github.jon_bassi.util;

import javafx.scene.control.TreeItem;

/**
 * Created by jon on 9/23/2016.
 * Communicate between controllers with this class, probably not the best way... but it works
 */
public class Context
{
    private final static Context instance = new Context();
    private TreeItem<String> newGroup;
    private boolean updateTreeView = false;

    public static Context getInstance()
    {
        return instance;
    }

    public boolean checkForNewGroup()
    {
        return updateTreeView;
    }

    public TreeItem<String> getNewGroup()
    {
        TreeItem<String> toReturn = newGroup;
        newGroup = null;
        updateTreeView = false;
        return toReturn;
    }

    public void setNewGroup(TreeItem<String> newGroup)
    {
        this.newGroup = newGroup;
        updateTreeView = true;
    }

}
