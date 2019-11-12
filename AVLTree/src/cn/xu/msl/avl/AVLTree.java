package cn.xu.msl.avl;

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

            return node;
        }


}
