package CLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxHeap {
    private final static Integer DELETED = 0;
    private int[] arr;
    private int cap;
    private int heapSize;
    MaxHeap (int capacity) {
        arr = new int[cap];
        cap = capacity;
        heapSize = cap;
    }
    MaxHeap (int[] nums) {
        arr = nums;
        cap = nums.length;
        heapSize = cap;
    }
    private int parent(int i) {
        return i >> 1;
    }
    private int leftChild(int i){
        return i << 1;
    }
    private int rightChild(int i){
        return (i << 1) + 1;
    }

    private void heapify(int i){
        int max = i;
        if (leftChild(i) < heapSize && arr[leftChild(i)]> arr[max]) max = leftChild(i);
        if (rightChild(i) < heapSize&& arr[rightChild(i)]> arr[max]) max = rightChild(i);
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(max);
        }
    }

    private void buildHeap(){
        int mid = (heapSize >> 1);
        for (int i = mid; i>-1; i++) {
            heapify(i);
        }
    }

    private void heapSort(){
        buildHeap();
        while (heapSize > 1) {  // 1, because only one element, by itself, doesn't need to be heapified.
            int out = heapSize - 1;
            int temp = arr[out];
            arr[out] = arr[0];
            arr[0] = temp;
            heapSize--;         // must first reduce heapSize!!
            heapify(0);
        }
    }

    public int peek(){
        return arr[0];
    }

    public int poll(){          // this is a max heap, not a heapSorted ascendingly-ordered array.
        int max = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;             // must first reduce heapSize!
        heapify(0);
        return max;
    }

    private void incr(int i, int k){    // inverse of heapify.
        while (i > 0 && arr[parent(i)] < k) {
            arr[i] = arr[parent(i)];
            i = parent(i);
        }
        arr[i] = k;
    }

    public void offer(int k){
        heapSize++;
        incr(heapSize-1, k);
    }

}



class Slower {
    private static int L;
    public int findKthLargest(int[] nums, int k)
    {
        heapSort(nums);
        return nums[nums.length - k];
    }

    private void heapSort(int[] nums)
    {
        buildHeap(nums);
        for(int i = L;i >=1; i--)
        {
            swap(nums, 0, i);
            L = L - 1;
            heapify(nums, 0);
        }
    }

    private void buildHeap(int[] nums)
    {
        L = nums.length-1;
        for(int i = L/2; i >=0; i--)
            heapify(nums, i);
    }

    //max-heap
    private void heapify(int[] nums, int i)
    {
        int l = 2 * i;
        int r = l + 1;
        int largest = i;
        if((l <= L) && (nums[l] > nums[largest]))
            largest = l;
        if((r <= L) && (nums[r] > nums[largest]))
            largest = r;
        if(largest != i)
        {
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }

    private void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class Faster {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        if (size < k) return -1;
        heapify(nums, size);

        while(k-- > 1) {
            swap(nums, 0 , --size);
            shiftdown(nums, size, 0);
        }
        return nums[0];
    }

    public void heapify(int[] nums, int size) {
        if (size <= 1) return;
        int lastWithChild = size / 2 - 1;

        while(lastWithChild >= 0) {
            shiftdown(nums, size, lastWithChild--);
        }
    }

    void shiftdown(int[] nums, int size, int pos) {
        while(pos < size) {
            int left = (pos + 1) * 2 - 1;
            if (left >= size)
                return ;
            int right = left + 1;
            int child = left;
            if (right < size && nums[left] < nums[right])
                child = right;
            if (nums[pos] < nums[child]) {
                swap(nums, pos, child);
                pos = child;
            } else {
                return ;
            }
        }
    }

    void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}

// 0417 ???????????
class Result {
    public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
        if(after==null || after.size()==0 || after.get(0).size()==0) return null;
        int m = after.size()-1, n = after.get(0).size()-1;
        for(int i=m; i>0; i--){
            for(int j=n; j>0; j--){
                // int t = i; i = j; j = t;
                System.out.println(i+" "+j);
                int sum = after.get(i).get(j) - after.get(i).get(j-1) - after.get(i-1).get(j) + after.get(i-1).get(i-1);
                List<Integer> temp = after.get(i);
                temp.set(j, sum);
            }
        }
        for(int i=m; i>0; i--){
            after.get(i).set( 0,   after.get(i).get(0) - after.get(i-1).get(0) );
        }
        for(int j=n; j>0; j--){
            after.get(0).set( j,   after.get(0).get(j) - after.get(0).get(j-1) );
        }
        return after;
    }
    public static void main(String[] args){
        List<List<Integer>> test = new ArrayList<>();
        for(int i=0; i<4; i++){
            List<Integer> l = Arrays.asList(1,2,3);
            int[] map = new int[100];
            Arrays.fill(map, 100);
            test.add(l);
        }
        System.out.println(test);
        System.out.println(findMatrix(test));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
        int i = (int)1e9;
        System.out.println(i);
    }
}
