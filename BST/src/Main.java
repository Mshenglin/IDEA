import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
     int[] a=new int[]{5,3,6,8,4,2};
     BST<Integer> bst=new BST<>();
     for (int num:a){
    bst.add(num);
     }
//        bst.preOrderNR();
//     System.out.println("======");
//        bst.preOrder();
//        System.out.println("======");
//        bst.inOrder();
//        System.out.println("======");
//        bst.levelOrder();
        int n =1000;
        Random random=new Random();
     for (int i=0;i<n;i++){
         bst.add(random.nextInt(10000));
     }
        ArrayList<Integer> nums= new ArrayList<>();
     while (!bst.isEmpty())
     {
         nums.add(bst.removeMin());
     }
     System.out.println(nums);
     for(int i=1;i<nums.size();i++)
     {
         if(nums.get(i-1)>nums.get(i))
         {
             throw new  IllegalArgumentException("Error");
         }
     }
    }

}
