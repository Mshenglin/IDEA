package com.xu.offer;

public class Node<E> {
    //储存数据
    public E e;
    //储存指向下一个节点的指针
    public Node next;
    //构造方法
    public Node(E e,Node next)
    {
        this.e=e;
        this.next=next;
    }
    public Node(E e)
    {
        this(e,null);
    }
    public Node(){

        this(null,null);
    }
    @Override
    public String toString(){
        return e.toString();
    }
}
