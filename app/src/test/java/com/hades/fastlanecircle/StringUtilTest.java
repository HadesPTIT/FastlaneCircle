package com.hades.fastlanecircle;

import com.hades.fastlanecircle.util.StringUtil;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {


    @Test
    public void milliSecondToTimer_Case1() {
        Assert.assertEquals(StringUtil.milliSecondsToTimer(1),"0:00");
    }

    @Test
    public void milliSecondToTimer_Case2() {
        Assert.assertEquals(StringUtil.milliSecondsToTimer(100),"0:00");
    }

    @Test
    public void milliSecondToTimer_Case3() {
        Assert.assertEquals(StringUtil.milliSecondsToTimer(1000),"0:01");
    }

    @Test
    public void milliSecondToTimer_Case4() {
        Assert.assertEquals(StringUtil.milliSecondsToTimer(100000),"1:40");
    }

    @Test
    public void milliSecondToTimer_Case5() {
        Assert.assertEquals(StringUtil.milliSecondsToTimer(3600000),"1:0:00");
    }

    @Test
    public void getProgressPercentage_Case1() {
        Assert.assertEquals(StringUtil.getProgressPercentage(0,0),0);
    }

    @Test
    public void getProgressPercentage_Case2() {
        Assert.assertEquals(StringUtil.getProgressPercentage(0,0),0);
    }

    @Test
    public void getProgressPercentage_Case3() {
        Assert.assertEquals(StringUtil.getProgressPercentage(1000,100000),1);
    }

    @Test
    public void getProgressPercentage_Case4() {
        Assert.assertEquals(StringUtil.getProgressPercentage(10000,100000),10);
    }

    @Test
    public void getProgressPercentage_Case5() {
        Assert.assertEquals(StringUtil.getProgressPercentage(50000,100000),50);
    }

    @Test
    public void getProgressPercentage_Case6() {
        Assert.assertEquals(StringUtil.getProgressPercentage(100000,100000),100);
    }


}
