import java.util.ArrayList;
import java.util.List;
/* Yet another practise of Merge sort */

public class Solution {

    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }
    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }

    public static void main(String[] args){
        Solution obj = new Solution();
        int[] array = {5,2,6,1};
        obj.countSmaller(array);
    }

}


 /*
    public List<Integer> countSmaller(int[] nums) {

        int[] counts = new int[nums.length];

        mergeSort(nums,counts);
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void mergeSort(int[] array,int [] counts){

        int[] indexArray = new int[array.length];
        for(int i = 0 ; i < array.length ; i++){
            indexArray[i] = i;
        }
        print(array);
        mergeSortHelper(array, 0 , array.length - 1,indexArray, counts);
        print(array);
    }

    public void mergeSortHelper(int[] array, int start, int end, int[] indexArray,int[] counts){
        if(start < end){
            int mid = (start + end)/2;
            mergeSortHelper(array,start,mid,indexArray,counts);
            mergeSortHelper(array,mid + 1, end,indexArray, counts);
            int[] temp = new int[end - start + 1];
            int i = start, j = mid + 1,count = 0;
            while(i <= mid && j <= end){
                if(array[i] <= array[j]){
                    temp[count++] = array[i++];
                }
                else{
                    temp[count++] = array[j++];
                }
            }
            while(i <= mid){
                temp[count++] = array[i++];
            }
            while(j <= end){
                temp[count++] = array[j++];
            }
            for(i = start,j = 0 ; i <= end ; i++,j++){
                array[i] = temp[j];
            }
        }
    }

    public void print(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    */
