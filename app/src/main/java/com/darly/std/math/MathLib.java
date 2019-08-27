/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.math;

/**
 * Description TODO: 计算题
 * Package com.darly.std.math
 * @author zhangyuhui
 * Date 2019/7/25 14:44
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class MathLib {

    /**
     * 已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位。
     * 出题人：——阿里巴巴出题专家：文景／阿里云 CDN 资深技术专家
     * 牛顿迭代法:  y = (x + c / x) / 2;
     * 实际上求的结果是曲线和X轴交接的地方
     * @param cons 输入参数
     * @return 返回结果（无限趋近的算法）
     */
    public static double sqrt(double cons){
        if (cons<0){
            return Double.NaN;
        }
        double per = cons;
        double next = (per+per/cons)/2;
        double lead = 1e-15;
        while (Math.abs(per-next)>lead){
            per = next;
            next = (per+per/cons)/2;
        }
        return per;
    }
}
