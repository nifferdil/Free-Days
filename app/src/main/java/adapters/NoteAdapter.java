package adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

import models.Note;
import ui.CategoryActivity;

/**
 * Created by niffer on 11/1/15.
 */
public class NoteAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Note> mNotes;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        mNotes = notes;
        mContext = context;
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
        TextView noteDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.note_list_item, null);
            holder = new ViewHolder();
            holder.dateLabel = (TextView) convertView.findViewById(R.id.dateLabel);
            holder.noteLabel = (TextView) convertView.findViewById(R.id.noteLabel);
            holder.noteDelete = (TextView) convertView.findViewById(R.id.noteDelete);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Note note = mNotes.get(position);

        holder.dateLabel.setText(note.getFormattedTime());
        holder.noteLabel.setText(note.getContent());

        holder.noteDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                note.delete();
                                Intent intent = new Intent(mContext, CategoryActivity.class);
                                mContext.startActivity(intent);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };

                AlertDialog show = new AlertDialog.Builder(mContext)
                        .setTitle("Alert")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener)
                        .show();
            }
        });

        return convertView;
    }
}
