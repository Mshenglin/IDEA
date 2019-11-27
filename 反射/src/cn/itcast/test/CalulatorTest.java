package cn.itcast.test;

import cn.itcast.junit.Caculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalulatorTest {
    /**
     * 初始化方法：
     * 用于资源的申请，所有的测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }
    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
    System.out.println("我被执行了");
    //1.创建计算器对象
        Caculator c =new Caculator();
        //2.调用add方法
        int  result=c.add(1,2);
        System.out.println(result);
        //使用断言的结果来判定成功还是失败
        Assert.assertEquals(3,result);

    }
}
