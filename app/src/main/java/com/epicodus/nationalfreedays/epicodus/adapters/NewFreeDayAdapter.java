package com.epicodus.nationalfreedays.epicodus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.AddedFreeDay;

import java.util.ArrayList;

public class NewFreeDayAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<AddedFreeDay> mAddedFreeDays;

        public NewFreeDayAdapter(Context context, ArrayList<AddedFreeDay> addedFreeDays) {
            mContext = context;
            mAddedFreeDays = addedFreeDays;
        }

        @Override
        public int getCount() {
            return mAddedFreeDays.size();
        }

        @Override
        public Object getItem(int position) {
            return mAddedFreeDays.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        private static class ViewHolder {
            TextView newFreeDayTitleLabel;
            TextView newFreeDayDateLabel;
            TextView newFreeDayDescriptionLabel;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.addedfreeday_list_item, null);
                holder = new ViewHolder();
                holder.newFreeDayTitleLabel = (TextView) convertView.findViewById(R.id.newFreeDayTitleLabel);
                holder.newFreeDayDateLabel = (TextView) convertView.findViewById(R.id.newFreeDayDateLabel);
                holder.newFreeDayDescriptionLabel = (TextView) convertView.findViewById(R.id.newFreeDayDescriptionLabel);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            AddedFreeDay addedFreeDay = mAddedFreeDays.get(position);

            holder.newFreeDayTitleLabel.setText(addedFreeDay.getNewFreeDayTitleText());
            holder.newFreeDayDateLabel.setText(addedFreeDay.getNewFreeDayDate());
            holder.newFreeDayDescriptionLabel.setText(addedFreeDay.getNewFreeDayDescription());

            return convertView;
        }
    }