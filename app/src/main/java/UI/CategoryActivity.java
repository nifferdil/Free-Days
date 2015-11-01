package ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

import models.Category;
import models.Note;
import models.User;

public class CategoryActivity extends ListActivity {

    private Category mCategory;
    private Button mNewNoteButton;
    private User mUser;
    private EditText mNewNoteText;
    private ArrayList<String> mNotes;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String name = getIntent().getStringExtra("categoryName");
        mCategory = Category.find(name);

        mNewNoteButton = (Button) findViewById(R.id.newNoteButton);
        mNewNoteText = (EditText) findViewById(R.id.newNoteText);

        mNotes = new ArrayList<String>();
        for ( Note note : mCategory.notes() ) {
            mNotes.add(note.getContent());
        }

//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNotes);
//        setListAdapter(mAdapter);

        mNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
    }

    private void addNote() {
        String content =  mNewNoteText.getText().toString();
        Note newNote = new Note(content, mCategory);
        newNote.save();
        mNotes.add(content);
        mAdapter.notifyDataSetChanged();
    }
}