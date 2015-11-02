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

    public static String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences mPreferences;
    private Button mNewCategoryButton;
    private User mUser;
    private EditText mNewCategoryText;
    private ArrayList<String> mCategories;
    private ArrayList<Note> mNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mPreferences = getApplicationContext().getSharedPreferences("freedays", Context.MODE_PRIVATE);

        mNewCategoryButton = (Button) findViewById(R.id.newCategoryButton);
        mNewCategoryText = (EditText) findViewById(R.id.newCategoryText);

        mCategories = new ArrayList<String>();
        for ( Category category : Category.all() ) {
            mCategories.add(category.getName());
        }

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
        mNewCategoryText.setText("");
    }
}
