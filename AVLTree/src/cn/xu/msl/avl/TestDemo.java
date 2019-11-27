package cn.xu.msl.avl;

import java.util.Random;

public class TestDemo {
    public static void main(String[] args) {
        AVLTree<Integer> avl=new AVLTree<>();
        BST<Integer> bst= new BST<>();
       int[] a=new int[]{ 4,3,2,1};
        for (int i = 1; i <= a.length; i++) {
         avl.add(i);
         bst.add(i);
        }
//        System.out.println( avl.isBST());
//        System.out.println( avl.isBalanced());
//        avl.inOrder();
        System.out.println(bst.removeMin());
    }
}
