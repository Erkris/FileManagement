package com.lp.pierrerubier.filemanagement.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lp.pierrerubier.filemanagement.R;

/**
 * Created by pierrerubier on 14/11/2014.
 */
public class MediaFragment extends Fragment {

    TextView mTVHelloText;
    ImageView mIVHelloText;

    String mHelloText;
    int mHelloImageResId;

    public MediaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.listview_item_row, container, false);

        mTVHelloText = (TextView) rootView.findViewById(R.id.textViewName);
        mIVHelloText = (ImageView) rootView.findViewById(R.id.imageViewIcon);

        if(mHelloText != null) {
            mTVHelloText.setText(mHelloText);
            mIVHelloText.setImageResource(mHelloImageResId);
        }

        return rootView;
    }

    public void setHelloParameters(String text, int imageResId) {
        mHelloImageResId = imageResId;
        mHelloText = text;
    }
}
