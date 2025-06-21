package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_interview_schedule extends BaseAdapter {
    String[] interview_schedule_id,time,place,date,description;
    Context context;
    public custom_interview_schedule(Context context, String[] testname, String[] from_time, String[] to_time, String[] date, String[] description) {

        this.interview_schedule_id = interview_schedule_id;
        this.context = context;
        this.place = place;
        this.time = from_time;
        this.description = this.description;
        this.date = date;
    }


    @Override
    public int getCount() {
        return interview_schedule_id.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        {

            LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View gridView;
            if (view == null) {
                gridView = new View(context);
                //gridView=inflator.inflate(R.layout.customview, null);
                gridView = inflator.inflate(R.layout.custome_view_company, null);

            } else {
                gridView = (View) view;

            }
            TextView tvplace = (TextView) gridView.findViewById(R.id.textView30);
            TextView tvdescription = (TextView) gridView.findViewById(R.id.textView32);
            TextView tvtime = (TextView) gridView.findViewById(R.id.textView28);
            TextView tvdate = (TextView) gridView.findViewById(R.id.textView26);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


            tvplace.setText(place[i]);
            tvdescription.setText(description[i]);
            tvtime.setText(time[i]);
            tvdate.setText(date[i]);


//
//    SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
//    String ip=sh.getString("ip","");
//
//    String url="http://" + ip + ":5000"+imimg[i];
//
//
//        Picasso.with(context).load(url). into(img);
//
            return gridView;
        }

    }
}
