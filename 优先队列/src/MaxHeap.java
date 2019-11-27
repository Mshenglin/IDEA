public class MaxHeap<E extends Comparable<E>> {
    private Array<E>  data;
    public MaxHeap(int capacity){
    data = new Array<E>(capacity);
    }
    public MaxHeap(){
        data=new Array<>();
    }
public int size(){
        return data.getSize();
}
public boolean isEmpty(){
        return data.isEmpty();
}
//返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent (int index){
        if(index==0)
        {
            throw new IllegalArgumentException("Throw");
        }
        return (index-1)/2;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index*2+2;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index*2+1;
    }
    //向用户中添加元素
    public void add(E e){
        data.addlast(e);
        siftUp(data.getSize()-1);
    }
    private void  siftUp(int k){
   while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0) {
   data.swap(k,parent(k));
   k=parent(k);
   }
    }
//从堆中取出最大元素
    public E extractMax(){
        E ret=data.get(0);
        data.swap(0,data.getSize()-1);
        siftDown(0);
        return  ret;
    }
    private void siftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if(j+1<data.getSize()&& data.get(j+1).compareTo(data.get(j))>0){
                j=rightChild(k);
            }
            //j都是最大值
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(k,j);
            k=j;
        }
    }
}
