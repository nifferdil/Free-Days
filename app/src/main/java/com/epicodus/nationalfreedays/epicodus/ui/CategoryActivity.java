package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.adapters.NoteAdapter;
import com.epicodus.nationalfreedays.epicodus.models.Category;
import com.epicodus.nationalfreedays.epicodus.models.Note;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends ListActivity {

    public static String TAG = MainActivity.class.getSimpleName();

    private Category mCategory;
    private ArrayList<Note> mNotes;
    @Bind(R.id.newNoteButton)Button mNewNoteButton;
    @Bind(R.id.daysButton)Button mDaysButton;
    @Bind(R.id.newNoteText)EditText mNewNoteText;
    private NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("categoryName");
        mCategory = Category.find(name);

        mNotes = new ArrayList<Note>();
        for (Note note : mCategory.notes()) {
            mNotes.add(note);
        }

        mAdapter = new NoteAdapter(this, mNotes);
        setListAdapter(mAdapter);

        mNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });

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
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
