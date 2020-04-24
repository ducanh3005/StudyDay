package com.darly.std;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void seq() {
        double d = Math.sqrt(3);
        System.out.println(d + "");
        System.out.println(sqrt(100001) + "");
    }

    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > 0) {
            x = y;
            y = (x + c / x) / 2;
            System.out.println(x + "");
        }
        return x;
    }

    @Test
    public void synchronousQueueQuiz () {
        long time = System.currentTimeMillis();
        String d = "asdkfj;ladsjf.asdfjklasjdhfmasdkf,sdfkajsdhf.lkjds";
        System.out.println( (getNumber(d)==null)+"_"+("".equals(getNumber(d))));
        String a="-2300next234..csdn.34.23";
        String b = "-太10s(00)0.00下1US";
        System.out.println( getNumber(a));
        System.out.println( getNumber(b));
        String c = "100-01US";
        System.out.println( getNumber(c));

        String e = "111123213.00232";
        String f = "11112321300232";
        System.out.println( getNumber(e));
        System.out.println( getNumber(f));
        String h = "...........";
        System.out.println( h+getNumber(h)+h);
        String j = null;
        System.out.println((getNumber(j)==null)+"_"+("".equals(getNumber(j))));
        String k = " ";
        System.out.println((getNumber(k)==null)+"_"+("".equals(getNumber(k))));
        System.out.println("总共耗时："+(System.currentTimeMillis()-time));
    }

    /**
     * 将字符串转换成数字（防止用户输入或者后台返回的数据中包含非数字，导致转换崩溃。耗时大概3ms）
     * 1、包含小数的字符串（xxx1.1xxx）进行小数点前后非数字移除，生成小数。
     * 2、不包含小数的字符串，移除非数字，生成整数。
     * 3、不包含数字的字符串，返回空字符串。
     * @param str 需要转换的字符串
     * @return 返回数字字符串
     */
    public static String getNumber(String str){
        if (str == null){
            return str;
        }
        StringBuffer buffer = new StringBuffer();
        if (str.startsWith("-")){
            buffer.append("-");
        }
        // 控制正则表达式的匹配行为的参数(小数)
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        //Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
        Matcher m = p.matcher(str);
        //m.find用来判断该字符串中是否含有与"(\\d+\\.\\d+)"相匹配的子串
        if (m.find()) {
            //如果有相匹配的,则判断是否为null操作
            //group()中的参数：0表示匹配整个正则，1表示匹配第一个括号的正则,2表示匹配第二个正则,在这只有一个括号,即1和0是一样的
            String mui = m.group(1) == null ? "" : m.group(1);
            //这个小数进行保存，由这个小数拆分字符串，对整数和小数进行前后补充。
            if (str.startsWith(mui)){
                buffer.append(mui);
                //字符串开始就是小数，则后面的数字都补充到小数后。
                String split  = str.replace(mui,"");
                if (split != null){
                    split = getIntegerNumber(split);
                    buffer.append(split);
                }
                return buffer.toString();
            }else if (str.endsWith(mui)){
                //字符串结束就是小数，则前面的数字都补充到小数前。
                String split  = str.replace(mui,"");
                if (split !=null){
                    split = getIntegerNumber(split);
                    buffer.append(split);
                }
                buffer.append(mui);
                return buffer.toString();

            }else {
                //字符串中间位置是小数，则需要前后补充。
                String [] split = str.split(mui);
                //整数补充部分
                String intNumber = split[0];
                if (intNumber!=null){
                    intNumber = getIntegerNumber(intNumber);
                    buffer.append(intNumber);
                }
                buffer.append(mui);
                //小数补充部分
                String cosNumber = split[1];
                if (cosNumber!=null){
                    cosNumber = getIntegerNumber(cosNumber);
                    buffer.append(cosNumber);
                }
                return buffer.toString();
            }
        } else {
            //如果匹配不到小数，就进行整数匹配
            buffer.append(getIntegerNumber(str));
        }
        return buffer.toString();
    }

    /**
     * 获取字符串整数
     * @param str 原始字符串
     * @return 返回数字字符串
     */
    public static String getIntegerNumber(String str){
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(str);
        if (m.find()){
            str = m.replaceAll("").trim();
        }
        return str;
    }


    @Test
    public void intet(){
        String[] key=  {"1","2","2"};
        String data = "{key:"+key+"}";
        System.out.printf(data);
    }
}