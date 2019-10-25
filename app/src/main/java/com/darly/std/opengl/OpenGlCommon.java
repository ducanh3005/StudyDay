package com.darly.std.opengl;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * Description TODO: 字节转换工具类
 * Package com.darly.std.opengl
 *
 * @author zhangyuhui
 * @date 2019/10/25 10:32
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class OpenGlCommon {

    /**执行着色器
     * @param type
     * @param shaderCode
     * @return
     */
    public static int loadShader(int type, String shaderCode){
        // 创造顶点着色器类型(GLES20.GL_VERTEX_SHADER)
        // 或者是片段着色器类型 (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);
        // 添加上面编写的着色器代码并编译它
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }


    /**
     * 将int[]转成IntBuffer
     *
     * @param arr
     * @return
     */
    private IntBuffer intBufferUtil(int[] arr) {
        IntBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asIntBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }


    /**
     * 将float[]数组转为OpenGl 所需要的FloatBuffer
     *
     * @param arr
     * @return
     */
    private FloatBuffer floatBufferUtil(float[] arr) {
        FloatBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asFloatBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }

    /**将short[]转ShortBuffer
     * @param arr
     * @return
     */
    private ShortBuffer shortBufferUtil(short[] arr){
        ShortBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*2，因为一个short占2个字节
        ByteBuffer dlb = ByteBuffer.allocateDirect(
                // (# of coordinate values * 2 bytes per short)
                arr.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        mBuffer = dlb.asShortBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }
}
