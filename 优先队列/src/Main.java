import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(n);
        Random random = new Random();
        for (int i = 0; i < n-1; i++) {
            maxHeap.add(random.nextInt());
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i-1]<arr[i])
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("sxsx");
            }
        }
    }

