package com.darly.imageeditor.editimage.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.darly.imageeditor.editimage.EditImageActivity;

/**
 * Created by panyi on 2017/3/28.
 */

public abstract class BaseEditFragment extends Fragment {
    protected EditImageActivity activity;

    protected EditImageActivity ensureEditActivity(){
        if(activity==null){
            activity = (EditImageActivity)getActivity();
        }
        return activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ensureEditActivity();
    }

    public abstract void onShow();

    public abstract void backToMain();
}//end class
