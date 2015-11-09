package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.Category;
import com.epicodus.nationalfreedays.epicodus.models.Note;
import com.epicodus.nationalfreedays.epicodus.models.User;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoteActivity extends ListActivity {

    public static String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences mPreferences;
    private ArrayList<String> mCategories;
    @Bind(R.id.newCategoryButton)Button mNewCategoryButton;
    @Bind(R.id.newNoteText)EditText mNewCategoryText;
    private ArrayAdapter<String> mAdapter;
    private User mUser;
    private ArrayList<Note> mNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);

        Note newNote = new Note();
        newNote.save();

        mPreferences = getApplicationContext().getSharedPreferences("freedays", Context.MODE_PRIVATE);

        mCategories = new ArrayList<String>();
        for ( Category category : Category.all() ) {
            mCategories.add(category.getName());
        }

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mCategories);
        setListAdapter(mAdapter);

        mNewCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              addCategory();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String thisCategoryName = mCategories.get(position);
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("categoryName", thisCategoryName);
        startActivity(intent);
    }

    private void addCategory() {
        String name = mNewCategoryText.getText().toString();
        Category newCategory = new Category(name);
        newCategory.save();
        mCategories.add(name);
        mAdapter.notifyDataSetChanged();
        mNewCategoryText.setText("");
    }
}
