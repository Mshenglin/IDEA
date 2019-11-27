package cn.xu.msl.avl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
@SuppressWarnings("all")
public class AVL<E extends Comparable<E>,V> {
    /**
     * Node变量
     */
    private class Node{
        public  E e;
        public V value;
        public    Node left,right;
        public int height;
        public Node(E e,V v) {
            this.e = e;
            this.value=value;
            left = null;
            right = null;
            height=1;
        }
    }
    private  Node root;  //根节点
    private int size;  //树中元素的个数
    public AVL(){
        root = null;
        size=0;

    }
    public int size(){return size;}
    public boolean isEmpty(){
        return size==0;
    }
    //得到该节点的高度
    private  int getHeight(Node node)
    {
        if(node==null)
            return 0;
        return node.height;
    }
    //平衡因子
    public int getBalanceFactor(Node node)
    {
        if(node==null)
            return 0;
        return getHeight(node.left)-getHeight(node.right);

    }
    //判断是否是二分搜素树

    //右旋转操作,
    private Node rightRotage(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        //向右旋转操作
        x.right = y;
        y.left = T3;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right) + 1);
        return x;
    }
    //左旋转操作
    private Node  leftRotage(Node y)
    {
        Node  x=y.right;
        Node   T3=x.left;
        //向右旋转
                x.left=y;
                y.right=T3;
        //维护 Height
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.right),getHeight(y.left));
        return  x;
    }

    public void add(E e,V value){
        root =  add(root ,e,value);
    }

//向以node为根的二分搜索树中添加元素e ，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E key,V value) {
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.e) < 0) {
            node.left = add(node.left,key,value);
        } else if (key.compareTo(node.e) > 0) {
            node.right = add(node.right, key,value);
        }
        else {
             node.value=value;
        }
        //更新height
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        //计算平衡因子
        int balanceFactor=getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1)
            System.out.println(balanceFactor);
             //ll
            if((balanceFactor>1)&&(getBalanceFactor(node.left)>=0) )//左子树的高
            {
               return rightRotage(node);
            }
            //RR
            if(balanceFactor<-1&&getBalanceFactor(node.right)<=0)
            {
                return  leftRotage(node);
            }
            //lR
        if ( balanceFactor>1&&getBalanceFactor(node.left)<0)
        {
           node.left= leftRotage(node.left);
           return rightRotage(node);
        }
        if(balanceFactor<-1 && getBalanceFactor(node.right)>0)
        {
            node.right=rightRotage(node.right);
            return  leftRotage(node);
        }
            return node;
    }
    //在二分搜索是否包含元素e
    public boolean contains(E e){
        return  contains(root,e);
    }
    //以node为根的二分搜索树是否包含元素e
    private boolean contains(Node node,E e)
    {
        if( node == null){
            return false;
        }
        if(e.compareTo(node.e)==0)
        {
            return true;
        }
        if(e.compareTo(node.e)<0)
            return contains(node.left,e);
        else {
            return contains(node.right,e);
        }
    }
    //二分搜索树的遍历
    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树的中序遍历
    //
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e+"\t ");
        inOrder(node.right);
    }
    //二分搜索树的后序遍历
    public void outOrder(){
        outOrder(root);
    }
    private void outOrder(Node node){
        if(node == null){
            return ;
        }

        outOrder( node.left );

        outOrder( node.right );
        System.out.println(node.e);

    }
    //二分搜索树的前序遍历的非递归
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null)
            {
                stack.push(cur.left);
            }
        }
    }
    //二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur= q.remove();
            System.out.print(cur.e+"\t");
            if(cur.left!=null)
            {
                q.add(cur.left);
            }
            if(cur.right!=null) {
                q.add(cur.right);
            }
        }
    }
    public boolean isBST(){
        //使用中序遍历，二分搜索树是一个有序的数列
        ArrayList<E> keys=new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {
            if(keys.get(i-1).compareTo(keys.get(i))>0)
                return false;
        }
        return true;
    }
    private void inOrder(Node node,ArrayList<E> keys)
    {
        if(node==null)
            return;
        inOrder(node.left,keys);
        keys.add(node.e);
        inOrder(node.right,keys);
    }
    //判断以node为根的二叉树是否是一颗平衡二叉树，递归实现
    public boolean isBalanced(){
        return  isBalanced(root);
    }
    private  boolean isBalanced(Node  node)
    {
        if(node==null)
        {
            return true;
        }
        int balanceFactor=getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1)
        {
            return false;
        }
        return isBalanced(node.right)&&isBalanced(node.left);
    }
    //删除二分搜索树中的最小值和最大值
    //
    public E minmum(){
        if(size==0)
        {
            throw new IllegalArgumentException("Bst is empty");
        }
        return minmum(root).e;
    }
    private  Node minmum(Node node){
        if(node.left==null){
            return node;
        }
        return minmum(node.left);
    }
    public E maxmum(){
        if(size==0)
        {
            throw new IllegalArgumentException("Bst is empty");
        }
        return maxmum(root).e;
    }
    private  Node maxmum(Node node){
        if(node.left==null){
            return node;
        }
        return maxmum(node.right);
    }
    //从二分搜索树中删除最小值所在的节点，返回最小值

    public E removeMin(){
        E ret  = minmum();
        root=removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在的节点，返回最大值

    public E removeMax(){
        E ret  = maxmum();
        root=removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }
    //
    public void remove(E e)
    {
        root= remove(root,e);
    }
    private Node remove(Node node,E e){
        if(node==null)
        {
            return null;
        }
        Node retNode;
        if(e.compareTo(node.e)<0)
        {
            node.left=remove(node.left,e);
           retNode= node;
        }
        else if(e.compareTo(node.e)>0)
        {
            node.right=remove(node.right,e);
            retNode= node;
        }
        else{
            //待删除的左子树为空的情况
            if(node.left==null)
            {
                Node rightNode=node.right;
                node.right=null;
                size--;
               retNode= rightNode;
            }
            //待删除的右子树为空
            if(node.right==null)
            {
                Node leftnode=node.left;
                node.left=null;
                size--;
                retNode= leftnode;
            }
//  待删除节点左右子树均不为空
//  找到比比待删除节点大的最小节点，及待删除节点右子树的最小节点
// 用这个节点顶替待删除的节点
            Node successor=minmum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            retNode= successor;
        }
        return retNode;
    }
    }

//private void add(Node node,E e){
//        if(e.equals(node.e)){
//            return;
//        }
//        else if(e.compareTo(node.e)<0 && node.left == null)
//        {
//
//            node.left=new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e)>0 && node.right == null)
//        {
//            node.right=new Node(e);
//            size++;
//            return;
//        }
//        if(e.compareTo(node.e)<0){
//            add(node.left,e);
//        }
//        else{
//            add(node.right,e);
//        }