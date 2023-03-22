package com.example.assignment.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment.R;
import com.example.assignment.object.Continue;
import com.example.assignment.object.ImgCustom;
import com.google.android.material.animation.Positioning;

import java.util.ArrayList;
import java.util.List;

public class ContinueAdapter extends ArrayAdapter<Continue> {

    private Context ct;
    private ArrayList<Continue> arrCont;

    public ContinueAdapter(@NonNull Context context, int resource, @NonNull List<Continue> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arrCont = new ArrayList<>(objects);
    }

    public void upDate(ArrayList<Continue> arr){
        this.arrCont.clear();
        this.arrCont.addAll(arr);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return arrCont.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_continue,null);
        }
        if(arrCont.size()>0){
            Continue c = arrCont.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.imageContinue);
            imgCustom.setColorFilter(Color.parseColor(c.message));
        }

        return convertView;
    }
}
