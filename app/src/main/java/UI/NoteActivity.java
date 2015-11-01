package ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

import models.Category;
import models.Note;
import models.User;

public class NoteActivity extends ListActivity {

    private SharedPreferences mPreferences;
    private Button mNewCategoryButton;
    private User mUser;
    private EditText mNewCategoryText;
    private ArrayList<String> mCategories;
    //private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Note newNote = new Note();
        newNote.save();

        mPreferences = getApplicationContext().getSharedPreferences("freedays", Context.MODE_PRIVATE);

        mNewCategoryButton = (Button) findViewById(R.id.newNoteButton);
        mNewCategoryText = (EditText) findViewById(R.id.newNoteText);

        mCategories = new ArrayList<String>();
        for ( Category category : Category.all() ) {
            mCategories.add(category.getName());
        }

//        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mCategories);
//        setListAdapter(mAdapter);

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
        //mAdapter.notifyDataSetChanged();
        mNewCategoryText.setText("");
    }
}
