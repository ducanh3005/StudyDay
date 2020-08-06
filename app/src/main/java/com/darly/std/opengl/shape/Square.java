package com.darly.std.opengl.shape;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Description TODO: 正方形图形
 * Package com.darly.std.opengl.shape
 *
 * @author zhangyuhui
 * @date 2019/10/25 10:24
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class Square {

    private FloatBuffer vertex;
    private ShortBuffer drawList;
    static final int COORDS_PER_VERTEX = 3;
    static float squareCoords[] = {
            -0.5f, 0.5f, 0.0f,
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.5f, 0.5f, 0.0f};
    private short order[] = {0, 1, 2, 0, 2, 3};

    public Square() {
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个float占4个字节
        ByteBuffer bb = ByteBuffer.allocateDirect(squareCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertex = bb.asFloatBuffer();
        vertex.put(squareCoords);
        vertex.position(0);
        // 初始化ByteBuffer，长度为arr数组的长度*2，因为一个short占2个字节
        ByteBuffer dlb = ByteBuffer.allocateDirect(order.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawList = dlb.asShortBuffer();
        drawList.put(order);
        drawList.position(0);
    }
}
