package com.example.spc;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_view_company extends BaseAdapter {

    String [] company_id,place,name,pin,post,district,state,country,email;
    Context context;
    ImageView img;

    public custom_view_company(Context context, String[] company_id, String[] name, String[] place, String[] pin,String[]  post, String[] district, String[] state, String[] country, String[] email) {


        this.context=context;
        this.company_id=company_id;
        this.place=place;
        this.name=name;
        this.pin=pin;
        this.post=post;
        this.district=district;
        this.state=state;
        this.country=country;
        this.email=email;




    }


    @Override
    public int getCount() {
        return company_id.length;
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
        TextView tvname = (TextView) gridView.findViewById(R.id.textView65);
        TextView tvplace = (TextView) gridView.findViewById(R.id.textView62);
        TextView tvpin = (TextView) gridView.findViewById(R.id.textView53);
        TextView tvpost = (TextView) gridView.findViewById(R.id.textView54);
        TextView tvdistrict = (TextView) gridView.findViewById(R.id.textView56);
        TextView tvstate = (TextView) gridView.findViewById(R.id.textView59);
        TextView tvcountry = (TextView) gridView.findViewById(R.id.textView63);
        TextView tvemail = (TextView) gridView.findViewById(R.id.textView58);
        ImageView imimg = gridView.findViewById(R.id.imageView2);


//    ImageView im=(ImageView) gridView.findViewById(R.id.imageView10);

//        tv1.setTextColor(Color.BLACK);


        tvname.setText(name[i]);
        tvplace.setText(place[i]);
        tvpin.setText(name[i]);
        tvpost.setText(post[i]);
        tvdistrict.setText(district[i]);
        tvstate.setText(state[i]);
        tvcountry.setText(country[i]);
        tvemail.setText(email[i]);


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
