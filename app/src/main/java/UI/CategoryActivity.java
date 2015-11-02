package ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

import adapters.NoteAdapter;
import models.Category;
import models.Note;
import models.User;

public class CategoryActivity extends ListActivity {

    private Category mCategory;
    private ArrayList<Note> mNotes;
    private Button mNewNoteButton;
    private Button mDaysButton;
    private EditText mNewNoteText;
    private User mUser;
//    private ArrayAdapter<String> mAdapter;
    private NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String name = getIntent().getStringExtra("categoryName");
        mCategory = Category.find(name);

        mNewNoteButton = (Button) findViewById(R.id.newNoteButton);
        mNewNoteText = (EditText) findViewById(R.id.newNoteText);

        mNotes = new ArrayList<Note>();
        for (Note note : mCategory.notes()) {
            mNotes.add(note);
        }

//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNotes);
//        setListAdapter(mAdapter);

        mAdapter = new NoteAdapter(this, mNotes);
        setListAdapter(mAdapter);

        mNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });

        mDaysButton = (Button) findViewById(R.id.daysButton);
        mDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, FreeDaysActivity.class);
                startActivity(intent);
            }
        });
    }

            private void addNote() {
                String content = mNewNoteText.getText().toString();
                Note newNote = new Note(content, mCategory);
                newNote.save();
                mNotes.add(newNote);
                mAdapter.notifyDataSetChanged();
                mNewNoteText.setText("");
            }
        }