package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_view_schedule_test extends BaseAdapter {
    String[] schedule_id, testname, from_time, to_time, date;
    Context context;

    public custom_view_schedule_test(Context context, String[] testname, String[] from_time, String[] to_time, String[] date) {

        this.schedule_id = schedule_id;
        this.context = context;
        this.testname = testname;
        this.from_time = from_time;
        this.to_time = to_time;
        this.date = date;
    }

    @Override
    public int getCount() {
        return schedule_id.length;
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
            TextView tvtestname = (TextView) gridView.findViewById(R.id.textView12);
            TextView tvfrom_time = (TextView) gridView.findViewById(R.id.textView14);
            TextView tvto_time = (TextView) gridView.findViewById(R.id.textView16);
            TextView tvdate = (TextView) gridView.findViewById(R.id.textView18);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


            tvtestname.setText(testname[i]);
            tvfrom_time.setText(from_time[i]);
            tvto_time.setText(to_time[i]);
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
