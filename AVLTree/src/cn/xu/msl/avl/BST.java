package cn.xu.msl.avl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
      public  E e;
    public    Node left,right;
    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
    }
    }
    private  Node root;
    private int size;
    public BST(){
        root = null;
        size=0;

    }
    public int size(){return size;}
public boolean isEmpty(){
        return size==0;
}
public void add(E e){
          root =  add(root ,e);

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
//向以node为根的二分搜索树中添加元素e  ，递归算法
    //返回插入新节点后二分搜索树的根
private Node add(Node node,E e ) {
    if (node == null) {
        size++;
        return new Node(e);
    }
    if (e.compareTo(node.e) < 0) {
        node.left = add(node.left, e);
    } else if (e.compareTo(node.e) > 0) {
        node.right = add(node.right, e);
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
        System.out.print(node.e+"\t");
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
        System.out.println(node.e);
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
        System.out.print(node.e+"\t");

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
           System.out.println(cur.e);
           if(cur.left!=null)
           {
               q.add(cur.left);
           }
            if(cur.right!=null) {
               q.add(cur.right);
           }
       }
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
        if(node.right==null){
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
            System.out.println(node.e);
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
        if(e.compareTo(node.e)<0)
        {
            node.left=remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0)
        {
            node.right=remove(node.right,e);
            return node;
        }
        else{
            //待删除的左子树为空的情况
            if(node.left==null)
            {
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除的右子树为空
            if(node.right==null)
            {
                Node leftnode=node.left;
                node.left=null;
                size--;
                return leftnode;
            }
//  待删除节点左右子树均不为空
//  找到比比待删除节点大的最小节点，及待删除节点右子树的最小节点
// 用这个节点顶替待删除的节点
         Node successor=minmum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }
}

