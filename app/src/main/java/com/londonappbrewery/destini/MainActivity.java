package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryText;
    private Button mAnsBtn1;
    private Button mAnsBtn2;
    private int mStory;
    private int mIndex = 0;

    private StoryTimeline[] mStoryBank = new StoryTimeline[] {
            new StoryTimeline(R.string.T1_Story, 0),
            new StoryTimeline(R.string.T2_Story, 1),
            new StoryTimeline(R.string.T3_Story, 2),
            new StoryTimeline(R.string.T4_End, 3),
            new StoryTimeline(R.string.T5_End, 4),
            new StoryTimeline(R.string.T6_End, 5)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mAnsBtn1 = findViewById(R.id.buttonTop);
        mAnsBtn2 = findViewById(R.id.buttonBottom);

        mStory = mStoryBank[mIndex].getStoryID();

        mStoryText.setText(mStory);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnsBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

    }

    private void checkAnswer(boolean ans1)
    {
        if (ans1)
        {
            if (mStoryBank[mIndex].getStoryNR() == 0)
            {
                mIndex = mIndex + 2;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                mAnsBtn1.setText(R.string.T3_Ans1);
                mAnsBtn2.setText(R.string.T3_Ans2);
            }
            else if (mStoryBank[mIndex].getStoryNR() == 1)
            {
                mIndex = mIndex + 1;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                mAnsBtn1.setText(R.string.T3_Ans1);
                mAnsBtn2.setText(R.string.T3_Ans2);
            }
            else if (mStoryBank[mIndex].getStoryNR() == 2)
            {
                mIndex = mIndex + 3;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                ExitButton();
            }
            else
            {
                finish();
            }
        }
        else
        {
            if (mStoryBank[mIndex].getStoryNR() == 0)
            {
                mIndex = mIndex + 1;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                mAnsBtn1.setText(R.string.T2_Ans1);
                mAnsBtn2.setText(R.string.T2_Ans2);
            }
            else if (mStoryBank[mIndex].getStoryNR() == 1)
            {
                mIndex = mIndex + 2;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                ExitButton();
            }
            else if (mStoryBank[mIndex].getStoryNR() == 2)
            {
                mIndex = mIndex + 2;
                mStory = mStoryBank[mIndex].getStoryID();
                mStoryText.setText(mStory);
                ExitButton();
            }
            else
            {
                finish();
            }
        }

    }

    private void ExitButton()
    {
        mAnsBtn1.setText("Exit");
        mAnsBtn2.setVisibility(View.GONE);
    }
}
