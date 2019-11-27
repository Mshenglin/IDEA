package cn.xu.msl.avl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        Queue<Integer> queue=new LinkedList<Integer>();
        for (int i = 0; i <5 ; i++) {
            queue.add(arr[i]);
        }
        int num=  queue.poll();
        ListNode list=new ListNode(num);
        while(!queue.isEmpty())
        {
            num= queue.poll();
            ListNode down=new ListNode(num);
            down.next=list;
            list=down;
        }
        while (list!=null)
        {
            System.out.println(list.val);
            list=list.next;
        }
//        Stack<Integer>  stack=new Stack<>();
//        while(head!=null)
//        {
//            stack.push(head.val);
//            head=head.next;
//        }
//        int num=stack.pop();
//        ListNode list=new ListNode(num);
//        while(!stack.isEmpty())
//        {
//            num=stack.pop();
//            ListNode down=new ListNode(num);
//            down.next=list;
//            down=list;
//        }
    }

        }

