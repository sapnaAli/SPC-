package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_view_reply extends BaseAdapter {
    String[] reply_id,date,complaint,reply;
    Context context;
    public custom_view_reply(Context context, String[] testname, String[] from_time, String[] to_time, String[] date) {

        this.reply_id = reply_id;
        this.context = context;
        this.complaint = complaint;
        this.reply = reply;
        this.date = date;
    }

    @Override
    public int getCount() {
        return reply_id.length;
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
            TextView tvcomplaint = (TextView) gridView.findViewById(R.id.textView20);
            TextView tvreply = (TextView) gridView.findViewById(R.id.textView22);
            TextView tvdate = (TextView) gridView.findViewById(R.id.textView24);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


            tvcomplaint.setText(complaint[i]);
            tvreply.setText(reply[i]);
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
