package cn.xu.msl.avl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("all")
public class AVLTree<E extends Comparable<E>> {
    private class Node{
        public Node left,right; //左右子树
        public E e;//保存的元素
        public int height;//高度

        public Node( E e) {
            left=null;
            right=null;
            this.e = e;
            this.height = 1;
        }
    }
        Node root; //根节点
        private int size;//该树存在的元素
        //构造方法
        public AVLTree(){
            root=null;
            size=0;
        }

        //得到该树存储元素的多少
        public int getSize(){
            return  size;
        }
        //该树是否为空
        public boolean isEmity(){
            return root==null;
        }
        //得到该节点的高度
        public int getHeight(Node node)
        {
            if(node==null)
            {
                return 0;
            }
            return node.height;
        }
        //得到该节点的平衡因子
    public int getBalanceFactor(Node node){
        if(node==null)
        {
            return 0;
        }
            return getHeight(node.left)-getHeight(node.right);
    }
    //右旋转操作
    private Node  rightRotage(Node y)
    {
        Node x=y.left;
        Node T3=x.right;
        //旋转操作
        x.right=y;
        y.left=T3;
        //更新height的高度
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.right),getHeight(y.right));
        //返回更新后的根节点
        return x;
    }
    //右旋转操作
    private Node leftRotge(Node y)
    {
        Node x = y.right;
        Node T3=x.left;
                //左旋转操作
        x.left=y;
        y.right=T3;
        //更新高度
        x.height=1+Math.max(getHeight(x.right),getHeight(x.left));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        return x;
    }
    //向AVL中添加元素
        public Node add(E e)
        {
            return root=add(root,e);
        }
        private Node add(Node node,E e)
        {
            //递归结束的条件
            if(node==null)
            {
                size++;
                return new Node(e);
            }
            if (node.e.compareTo(e)>0)//传入的参数小于该节点的值
            {
                node.left=add(node.left,e);
            }
            if(node.e.compareTo(e)<0)//传入的参数大于该节点的值
            {
                node.right=add(node.right,e);
            }
            //更新节点的高度
          node.height=1+Math.max(getHeight(node.right),getHeight(node.left));
            //判断该树是否是平衡二叉树
            int balanceFactor=getBalanceFactor(node);
            if(Math.abs(getBalanceFactor(node))>1) {
                /**
                 * 判断该节点旋转的类型
                 */
                //LL型
                if ((balanceFactor>1)&&(getBalanceFactor(node.left)>=0))
                {
                  return rightRotage(node);
                }
                //RR型
                if ((balanceFactor<-1)&&(getBalanceFactor(node.right)<=0))
                {
                    return leftRotge(node);
                }
                //LR型
                if((balanceFactor>1)&&(getBalanceFactor(node.left)<0))
                {
                    node.left=leftRotge(node.left);
                    return  rightRotage(node);
                }
                //RL型
                if ((balanceFactor<-1)&&(getBalanceFactor(node.right)>0))
                {
                    node.right=rightRotage(node.right);
                    return  leftRotge(node);
                }
            }
            return node;
        }
        //前序遍历
     public void   preOrder()
     {
         preOrder(root);
     }
     private void preOrder(Node node)
     {
         if(node==null)
             return;
         System.out.println(node.e);
         preOrder(node.left);
         preOrder(node.right);
     }

    //中序遍历
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
    //后序遍历
    public void  outOrder()
    {
        outOrder(root);
    }
    private void outOrder(Node node){
            if(node==null)
                return;
            outOrder(node.left);
            outOrder(node.right);
        System.out.println(node.e);
    }
    //前序遍历的非递归实现
    public void   preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(stack.isEmpty())
        {
            Node cur=stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null)
            {
                stack.push(cur.right);
            }
            if(cur.left!=null)
            {
                stack.push(cur.left);
            }
        }
    }


    //层序遍历
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty())
        {
            Node cur= queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
            {
                queue.add(cur.left);
            }
            if(cur.right!=null)
            {
                queue.add(cur.right);
            }
        }
    }

}
