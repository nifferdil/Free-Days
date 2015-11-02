package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

import models.Note;

/**
 * Created by niffer on 11/1/15.
 */
public class NoteAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Note> mNotes;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        mContext = context;
        mNotes = notes;
    }

    @Override
    public int getCount() {
        return mNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return mNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder {
        TextView noteLabel;
        TextView dateLabel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.note_list_item, null);
            holder = new ViewHolder();
            holder.dateLabel = (TextView) convertView.findViewById(R.id.dateLabel);
            holder.noteLabel = (TextView) convertView.findViewById(R.id.noteLabel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = mNotes.get(position);

        holder.dateLabel.setText(note.getFormattedTime());
        holder.noteLabel.setText(note.getContent());

        return convertView;
    }
}
