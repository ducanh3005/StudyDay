package com.darly.std.widget.view;

import android.content.Context;

public class DoMainModule {

    public static DoMainView instance(Context context){
        return new DoMainView(context);
    }

    public void connect(DoMainView view){
         view.connect();
    }

}
