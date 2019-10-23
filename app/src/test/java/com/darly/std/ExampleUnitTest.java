package com.darly.std;

import android.annotation.TargetApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
    }
    @Test
    @TargetApi(22)
    public void po() {
        Stack<String> s = new Stack<String>();
        System.out.println("------isEmpty");
        System.out.println(s.isEmpty());
        System.out.println("------push");
       System.out.println(s.push("1"));
       System.out.println(s.push("2"));
       System.out.println(s.add("3"));
        it(s);
        System.out.println("------pop");
        String str = s.pop();
        it(s);
        System.out.println(str);
        System.out.println("------peek");
        str = s.peek();
        it(s);
        System.out.println(str);
        System.out.println("------last");
        System.out.println(s.lastElement());
        System.out.println("------remove");
        System.out.println(s.remove(1));
        System.out.println("------search");
        int i = s.search("2");
        System.out.println(i);
        i = s.search("1");
        System.out.println(i);
        i = s.search("none");
        System.out.println(i);
    }

    public static void it(Stack<String> s){
        System.out.print("iterator:");
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+";");
        }
        System.out.print("\n");
    }


    @Test
    public void empty(){
        List<String > data  = new ArrayList<>();
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                o1.getBytes();
                o2.getBytes();
                    System.out.println(1);
                    return 1;
            }
        });
    }
}