package com.darly.std.opengl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Description TODO:OpenGL加载界面
 * Package com.darly.std.opengl
 *
 * @author zhangyuhui
 * @date 2019/10/23 14:31
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class OpenGlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OpenGlSurfaceView view = new OpenGlSurfaceView(this);
        setContentView(view);
    }
}
