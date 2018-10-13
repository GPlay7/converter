package com.best.toukir.currencycinverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by toukir on 4/19/16.
 */
public class CustomArrayAdapter extends BaseAdapter{


    private String[] countryName, currencyName, currencyCode;
    private LayoutInflater inflater;
    public CustomArrayAdapter(Context context, String[] a1, String[] a2, String[] a3){

        this.countryName = a1;
        this.currencyName = a2;
        this.currencyCode = a3;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if (convertView == null){
            currentView = inflater.inflate(R.layout.items,parent,false);
        }

        TextView counName = (TextView) currentView.findViewById(R.id.txtCountryName);
        counName.setText(countryName[position]);

        TextView currName = (TextView) currentView.findViewById(R.id.txtCurrencyName);
        currName.setText(currencyName[position]);

        TextView codes = (TextView) currentView.findViewById(R.id.txtCode);
        codes.setText(currencyCode[position]);

        return currentView;
    }
}
