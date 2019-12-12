package Stack;

public class ArrayStack {
    private int[] arr;
    /**
     *   栈的大小
     */
    private int size;
    /**
     * 栈中的元素个数
     */
     private int count; 

    public ArrayStack(int size) {
        this.arr = new int[size];
        count = 0;
        this.size = size;
    }
    public void  push(int value){
        if(arr.length==count) {
            resize(size);
        }
        arr[count]=value;
        ++count;
    }

    /**
     * 移除栈顶的元素，并返回他的值
     * @return
     */
    public int pop(){
        if (count==0){
            return -1;
        }
        int temp=arr[count-1];
        --count;
        return temp;
    }
    private void resize(int size){
        int resize=size*2;
        int[] newarr= new int[resize];
        for (int i = 0; i < this.arr.length; i++) {
            newarr[i]=arr[i];
        }
        arr=newarr;
    }
}
