public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
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
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;//链表的虚拟头节点
   private int size;   //该链表的长度
    LinkedList(){
dummyHead=new Node(null,null);
size=0;
    }
    //获取链表的元素的个数
    public int getSize(){
        return size;
    }
    //判断该链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表头添加元素新的元素e

    //在链表index的中间插入元素
    public void add(int index,E e){
        if(index < 0||index > size){
            throw new IllegalArgumentException("Add failed");
        }
//        if(index == 0)
//        {
//            addFrist(e);
//        }
        else{
            Node prev = dummyHead;
            //遍历该链表到需要添加的前一个节点上
            for (int i = 0; i <index ; i++) {
                prev=prev.next;//进行节点的遍历
            }
//            Node node=new Node(e);//创建一个新的对象
//                node.next=prev.next;//指向prev下一个节点
//                prev.next=node;
            prev.next= new Node(e,prev.next);
            size++;
        }
    }
    public void addFrist(E e){
//        Node node=new Node(e);
//        node.next=head;//将该节点与链表头相连
//        head=node;//更新head
        //下面这句话与上面的三句话是等价的
//        head= new Node(e,head);
//        size++;
        add(0,e);
    }
public void addLast(E e)
{
    add(size,e);
}
//获得链表的第index（0-based）个位置的元素(不常用)
public E get(int index){
        if(index<0|| index>=size)
        {
throw new IllegalArgumentException("Get failed.");
        }
        Node cur=dummyHead.next;//遍历到需要寻找的节点
    for (int i = 0; i < index ; i++) {
        cur=cur.next;
    }
    return cur.e;
}
public E getLast(){
        return  get(size-1);
}
//修改链表中的元素
public void set(int index , E e)
{
Node cur=dummyHead.next;
    for (int i = 0; i < index ; i++) {
        cur=cur.next;
    }
    cur.e=e;
}
//查找链表中是否有元素
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while(cur != null)
        {
            if(cur.equals(e)){
                return true;
        }
            cur=cur.next;
        }
        return false;
    }
    //在链表中删除元素
    public E remove(int index)
    {
        if(index < 0 || index >=size)
        {
            throw new IllegalArgumentException("Remove failed");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev=prev.next;//遍历 链表到地删除的前一个节点
        }
        Node retnode=prev.next;
        prev.next=retnode.next;
        retnode.next=null;
        size--;
return retnode.e;
    }
     public E removeFrist(){
       return remove(0);
     }
    public E removeList(int index){
        return remove(size-1);
    }
    public  String toString(){
        StringBuilder res=new StringBuilder();
        Node cur=dummyHead.next;
        while(cur!=null)
        {
            res.append(cur + "-->");
            cur=cur.next;
        }
        res.append("NUll");
        return res.toString();
    }


}
