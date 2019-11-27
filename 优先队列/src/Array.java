
public class Array<E> {
    private E[] data;
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    //构造函数，传入数组容量
    public  Array(int capity){
        data=(E[])new Object[capity];
        size=0;
    }
    public Array(){
        this(10);
    }
    //得到该数组元素的个数
    public int getSize() {
        return size;
    }
    //获得该数组元素的容量
    public int getCapity(){
        return data.length;
    }
    //判断该该数组是否为空
    public boolean isEmpty() {
        return size==0;
    }
    //向数组元素末尾添加元素
    public void  addlast(E m){
//        if (data.length==size){
//            throw new IllegalArgumentException("异常，数组下标越界");
//        }
//        else{
//            data[size]=m;
//            size++;
//        }
        add(size,m);
    }

    //向指定位置插入元素
    public void add(int m,E n){
        if (data.length==size){
            resize(2*data.length);
        }
        if(m>size||m<0)
        {
            throw new IllegalArgumentException("Add Failed.Require,m>size||m<0");
        }
        for (int i = size-1 ; i >=m; i--) {
            data[i+1]=data[i];
        }
        data[m]=n;
        size++;
    }
    //向数组首位置添加元素
    public void addFrist(E m){
        add(0,m);
    }
    //取出指定位置上的元素
    E get(int index){
        if (index<0||index >=size)
        {
            throw new IllegalArgumentException("FindFailed.");
        }
        return data[index];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFrist(){
        return data[0];
    }
    //修改指定位置的元素
    void set(int index,E e ){
        if ((index<0||index>=size))
        {
            throw new IllegalArgumentException("Add Failed.Array is full");
        }

        data[index]=e;
    }
    //在数组中,是否存在一个元素
    public boolean contains(E e){
        for (int i = 0; i < size ; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }
    //在数组中,是否存在一个元素,存在返回索引,不从在返回-1
    public int find(E e){
        for (int i = 0; i < size ; i++) {
            data[i].equals(e);
            return i;
        }        return -1;
    }
    //删除指定位置的元素,并返回该元素
    public E remove(int index){
        if (index<0||index>size)
        {
            throw new IllegalArgumentException("remove is fail");
        }
        if (data.length==size){
            throw new IllegalArgumentException("Add Failed.Array is full");
        }
        if(size==data.length/4&&data.length/2!=0)
        {
            resize(data.length/2);
        }
        E m=data[index];
        for (int i = index+1; i <size; i++) {
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;    //loitering object ！= memory leak
        return  m;
    }
    public E removeFrist(){
        return remove(0);
    }
    public E removelast(){
        return remove(size-1);
    }
    //删除数组中的元素e
    public boolean removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
            return true;
        }
        return false;
    }
public void swap(int i,int j){
        //System.out.println(i+"-"+j);
        if (i<0||i>=size||j<0||j>=size){
            throw new IllegalArgumentException("Throw");
        }
        E t;
        t=data[i];
        data[i]=data[j];
        data[j]=t;
}
    @Override
    //重写toString方法
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d ,capacity = %d",size,data.length));
        res.append("[");
        for (int i = 0; i <size ; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append("]");
        return  res.toString();
    }
    //实现动态数组
    private void resize(int newCapacity)
    {
        E[] newData=(E[])new Object[newCapacity];   //不能直接实例化泛型对象，通过强制转化
        for (int i = 0; i <size ; i++) {
            newData[i]=data[i];
        }
        data=newData;
    }
//    private void resizes(int newCapacity){
//        E[] newData= (E[]) new Object[newCapacity];
//        for (int i = 0; i <size ; i++) {
//         newData[i]=data[i];
//
//        }
//        data=newData;
//    }
}
