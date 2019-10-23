package com.darly.std.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Description TODO: OpenGL 界面渲染
 * Package com.darly.std.opengl
 *
 * @author zhangyuhui
 * @date 2019/10/23 14:22
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class OpenGlSurfaceView extends GLSurfaceView {

    private OpenGlRender render;

    public OpenGlSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public OpenGlSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        render = new OpenGlRender();
        setRenderer(render);
    }

}
