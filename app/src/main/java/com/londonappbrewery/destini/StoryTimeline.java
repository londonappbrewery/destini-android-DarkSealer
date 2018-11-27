package com.londonappbrewery.destini;

public class StoryTimeline {
    private int mStoryID;
    private int mStoryNR;

    //Constructor
    public StoryTimeline (int storyResourcesID, int storyNR)
    {
        mStoryID = storyResourcesID;
        mStoryNR = storyNR;
    }

    public int getStoryNR()
    {
        return mStoryNR;
    }

    public void setStoryNR(int storyNR)
    {
        mStoryNR = storyNR;
    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }
}
