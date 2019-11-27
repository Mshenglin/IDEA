package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 元注解：用来描述注解的注解
 * @Target   描述注解能够作用的位置
 * @Retention  描述注解被保留的阶段
 * @Documented 描述注解是否被抽取到文档
 */
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface myAnno {
    public  String  show();   //注解的属性
}
