package ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;

import models.FreeDay;
import models.FreeDayLib;

public class FreeDaysActivity extends AppCompatActivity {

    private TextView mNameLabel;
    private TextView mDateLabel;
    private TextView mDescriptionLabel;
    private TextView mWebsiteLabel;
    private Button mNextButton;
    private Button mAddNote;

    private FreeDayLib mFreeDayLib;
    private FreeDay mCurrentFreeDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_days);

        mNameLabel = (TextView) findViewById(R.id.nameLabel);
        mDateLabel = (TextView) findViewById(R.id.dateLabel);
        mWebsiteLabel = (TextView) findViewById(R.id.websiteLabel);
//        if (mWebsiteLabel != null) {
//            mWebsiteLabel.setMovementMethod(LinkMovementMethod.getInstance());
//        }
        mDescriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
        mNextButton = (Button) findViewById(R.id.nextButton);
        mAddNote = (Button) findViewById(R.id.addNote);
        mFreeDayLib = new FreeDayLib();
        mCurrentFreeDay = mFreeDayLib.getFreeDays().get(0);

        setLayoutConTent();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentFreeDay = mFreeDayLib.nextFreeDay(mCurrentFreeDay);
                setLayoutConTent();
            }
        });

        mAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeDaysActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });

//        mWebsiteLabel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mCurrentFreeDay.getWebsite()));
//                startActivity(intent);
//            }
//        });
    }

    private void setLayoutConTent() {
        mNameLabel.setText(mCurrentFreeDay.getTitle());
        mDateLabel.setText(mCurrentFreeDay.getDate());
        mWebsiteLabel.setText(mCurrentFreeDay.getWebsite());
        mDescriptionLabel.setText(mCurrentFreeDay.getDescription());
    }
}
