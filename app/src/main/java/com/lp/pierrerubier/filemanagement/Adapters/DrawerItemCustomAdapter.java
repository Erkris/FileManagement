package com.lp.pierrerubier.filemanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lp.pierrerubier.filemanagement.Items.ObjectDrawerItem;
import com.lp.pierrerubier.filemanagement.R;

import java.util.ArrayList;

/**
 * Created by pierrerubier on 14/11/2014.
 */
public class DrawerItemCustomAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<ObjectDrawerItem> drawerItems;

    public DrawerItemCustomAdapter(Context context, ArrayList<ObjectDrawerItem> menuMediasItems) {
        mContext = context;
        drawerItems = menuMediasItems;
    }

    @Override
    public int getCount() {
        return drawerItems.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        RelativeLayout layout;

        if(convertView == null) {
            layout = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.listview_item_row, null);
        } else {
            layout = (RelativeLayout)convertView;
        }

        TextView tvName = (TextView)layout.findViewById(R.id.textViewName);
        ImageView ivIcon = (ImageView)layout.findViewById(R.id.imageViewIcon);

        tvName.setText(drawerItems.get(position).name);
        ivIcon.setImageResource(drawerItems.get(position).icon);

        return layout;
    }


}