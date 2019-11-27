package cn.itcast.annotation;

/**
 * JDK预定义的一些注解
 *  * @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
 * 	* @Deprecated：该注解标注的内容，表示已过时
 * 	* @SuppressWarnings：压制警告
 */
@SuppressWarnings("all")//压制警告
public class AnnoDemo {
    @Override
    public String toString(){
        return  "";
    }
    @Deprecated
    public  void show1() {
        System.out.println("过时的");
    }

}
