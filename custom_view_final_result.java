package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_view_final_result  extends BaseAdapter {
String[] final_result_id,date,mark;
    Context context;
    public custom_view_final_result(Context context, String[] testname, String[] from_time, String[] to_time) {

        this.final_result_id = final_result_id;
        this.context = context;
        this.mark = mark;
        this.date = date;


    }

    @Override
    public int getCount() {
        return final_result_id.length;
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
            TextView tvmark = (TextView) gridView.findViewById(R.id.textView34);
            TextView tvdate = (TextView) gridView.findViewById(R.id.textView36);

//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


            tvmark.setText(mark[i]);
            tvdate.setText(date[i]);


//
//    SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(context);
//    String ip=sh.getString("ip","");
//
//    String url="http://" + ip + ":5000"+imimg[i];
//        Picasso.with(context).load(url). into(img);
//
            return gridView;
        }

    }
}
