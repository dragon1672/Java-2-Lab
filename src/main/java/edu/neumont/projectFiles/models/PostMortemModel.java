package edu.neumont.projectFiles.models;

import java.util.ArrayList;

/**
 * Created by awayman on 5/19/2015.
 */
public class PostMortemModel
{
    ArrayList<PostPlayerModel> playerModels;

    public PostMortemModel()
    {
        playerModels = new ArrayList<>();

    }

    public PostMortemModel(ArrayList<PostPlayerModel> arrayList)
    {
        playerModels = arrayList;
    }

    public PostMortemModel(PostPlayerModel first, PostPlayerModel second)
    {
        playerModels = new ArrayList<>();
        playerModels.add(first);
        playerModels.add(second);
    }
}
