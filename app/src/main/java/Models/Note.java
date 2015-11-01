package models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by niffer on 10/30/15.
 */
@Table( name = "Notes", id = "_id")
public class Note extends Model{

    @Column (name = "Content")
    private String mContent;

    @Column(name = "Category")
    private Category mCategory;

    public Note() {
        super();
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public Note(String content, Category category) {
        super();
        mContent = content;
        mCategory = category;
    }

//    public User getUser() {
//        return mUser;
//    }
//
//    public void setUser(User user) {
//        mUser = user;
//    }

    public static List<Note> all() {
        return new Select()
                .from(Note.class)
                .execute();
    }
}
