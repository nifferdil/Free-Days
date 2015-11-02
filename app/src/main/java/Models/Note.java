package models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import java.util.Date;

/**
 * Created by niffer on 10/30/15.
 */
@Table( name = "Notes", id = "_id")
public class Note extends Model{

    @Column (name = "Content")
    private String mContent;

    @Column(name = "CreatedAt")
    private long mCreatedAt;

    @Column(name = "Category")
    private Category mCategory;

    public Note() {
        super();
    }

    public Note(String content, Category category) {
        super();
        mContent = content;
        mCategory = category;
        mCreatedAt = new Date().getTime();
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(long createdAt) {
        mCreatedAt = createdAt;
    }

//    public User getUser() {
//        return mUser;
//    }
//
//    public void setUser(User user) {
//        mUser = user;
//    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d 'at' h:mma");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Los Angeles"));
        return formatter.format(mCreatedAt);
    }

    public static List<Note> all() {
        return new Select()
                .from(Note.class)
                .execute();
    }
}
