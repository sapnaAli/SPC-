package com.example.spc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_view_skill extends BaseAdapter {
    String[] skill_id,skill_name;
    Context context;
    public custom_view_skill(Context context, String[] skill_id, String[] skill_name) {
    this.context=context;
    this.skill_id=skill_id;
    this.skill_name=skill_name;
    }

    @Override
    public int getCount() {
        return skill_id.length;
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
        TextView tvskillname = (TextView) gridView.findViewById(R.id.textView10);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


        tvskillname.setText(skill_name[i]);


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
