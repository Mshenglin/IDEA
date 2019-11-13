package cn.xu.msl.avl;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = new int[]{9, 4, 3, 2};
//        System.out.println(Find(4, a));
        for (int i = 0; i < b.length; i++) {
            Boolean flag = Find(b[i], a);
            if (flag == false) {
                System.out.println(b[i]);
            }


//            int[] array = {1, 2, 3};
//            System.out.println(Find(3, array));
        }
    }
    public static boolean Find(int e,int[] a)
    {
        int mid,left,right;
        left=0;
        right=a.length-1;

        while(left<=right)
        {
            mid=(left+right)/2;
            if(e>a[mid])
            {
                left=mid+1;
            }
            else if(e<a[mid])
            {
                right=mid-1;
            }
            else {
                return  true;
            }
        }
        return false;
    }
}
