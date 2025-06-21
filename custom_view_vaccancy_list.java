package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_view_vaccancy_list extends BaseAdapter {
    String[] jobtitle, vaccancy_count, from_date, to_date;
    Context context;

    public custom_view_vaccancy_list(Context context, String[] jobtitle, String[] vaccancy_count, String[] from_date, String[] to_date) {

        this.context=context;
        this.jobtitle=jobtitle;
        this.vaccancy_count=vaccancy_count;
        this.from_date=from_date;
        this.to_date=to_date;
    }

    @Override
    public int getCount() {
        return jobtitle.length;
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
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (view == null) {
            gridView = new View(context);
            //gridView=inflator.inflate(R.layout.customview, null);
            gridView = inflator.inflate(R.layout.custome_view_company, null);

        } else {
            gridView = (View) view;

        }
        TextView tvjobtitle = (TextView) gridView.findViewById(R.id.textView2);
        TextView tvvaccancycount = (TextView) gridView.findViewById(R.id.textView4);
        TextView tvfromdate = (TextView) gridView.findViewById(R.id.textView6);
        TextView tvtodate = (TextView) gridView.findViewById(R.id.textView8);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


        tvjobtitle.setText(jobtitle[i]);
        tvvaccancycount.setText(vaccancy_count[i]);
        tvfromdate.setText(from_date[i]);
        tvtodate.setText(to_date[i]);



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
