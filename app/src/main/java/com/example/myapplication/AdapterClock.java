package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterClock extends BaseAdapter {
    Context context;
    ArrayList<Timeclock> timeclocks = new ArrayList<>();
    int layout;

    public AdapterClock(Context context, ArrayList<Timeclock> timeclocks, int layout) {
        this.context = context;
        this.timeclocks = timeclocks;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return timeclocks.size();
    }

    @Override
    public Object getItem(int position) {
        return timeclocks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout,null);
        TextView txtCongviec = convertView.findViewById(R.id.textviewTencongviec);
        TextView txtThoigian = convertView.findViewById(R.id.textviewThoigian);
        ToggleButton toggleButton = convertView.findViewById(R.id.toogleButton);

        final Timeclock timeclock = (Timeclock) getItem(position);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH : mm");


        txtThoigian.setText(simpleDateFormat.format(timeclock.getThoigian()));
        txtCongviec.setText(timeclock.getTencongviec());
        toggleButton.setChecked(timeclock.isToggle());
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeclocks.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
