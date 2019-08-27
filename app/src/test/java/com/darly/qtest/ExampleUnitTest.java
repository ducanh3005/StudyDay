package com.darly.qtest;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static java.lang.Math.sqrt;
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
}