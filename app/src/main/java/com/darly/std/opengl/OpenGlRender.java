package com.darly.std.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import com.darly.std.opengl.shape.Square;
import com.darly.std.opengl.shape.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * Description TODO: OpenGL渲染
 * Package com.darly.std.opengl
 *
 * @author zhangyuhui
 * @date 2019/10/23 14:24
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class OpenGlRender implements GLSurfaceView.Renderer {
    private static String TAG = "OpenGlRender";
    private Triangle triangle;
    private Square square;


    //定义一个投影
    private float[] mVPMatrix = new float[16];
    private float[] mProjectMatrix = new float[16];
    private float[] mViewMatrix = new float[16];


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        triangle = new Triangle();
        square = new Square();
        Log.d(TAG, "onSurfaceCreated() called with: gl = [" + gl + "], config = [" + config + "]");
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;
        // 这个投影矩阵被应用于对象坐标在onDrawFrame（）方法中
        Matrix.frustumM(mProjectMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
        Log.d(TAG, "onSurfaceChanged() called with: gl = [" + gl + "], width = [" + width + "], height = [" + height + "]");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        //定义一个相机视图
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        Matrix.multiplyMM(mVPMatrix, 0, mProjectMatrix, 0, mViewMatrix, 0);
        triangle.onDraw(mVPMatrix);
    }

}