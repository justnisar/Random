package com.ebay.standards.registry.store.dao;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<Integer> result;

  public List<Integer> countSmaller(int[] nums) {

    result = new ArrayList<>();
    int[] indexArray = new int[nums.length];
    for(int i = 0 ; i < nums.length ; i++){
      indexArray[i] = i;
      result.add(0);
    }
    mergeSortHelper(nums, indexArray,0 , nums.length - 1);
    return result;
  }

  public void mergeSortHelper(int[] array,int[] indexArray, int start, int end){
    if(start < end){
      int mid = (start + end)/2;
      mergeSortHelper(array,indexArray, start,mid);
      mergeSortHelper(array, indexArray, mid + 1, end);
      int[] temp = new int[end - start + 1];
      int i = start, j = mid + 1,count = 0;
      int noOfSmaller = 0;
      while(i <= mid && j <= end){
        if(array[indexArray[i]] <= array[indexArray[j]]){
          // get the index of the element from left
          result.set(indexArray[i], result.get(indexArray[i]) + noOfSmaller);
          temp[count++] = indexArray[i++];
        }
        else{
          noOfSmaller++;
          temp[count++] = indexArray[j++];
        }
      }
      while(i <= mid){
        // get the index of the element from left
        result.set(indexArray[i], result.get(indexArray[i]) + noOfSmaller);
        temp[count++] = indexArray[i++];
      }
      while(j <= end){
        noOfSmaller++;
        temp[count++] = indexArray[j++];
      }
      for(i = start,j = 0 ; i <= end ; i++,j++){
        indexArray[i] = temp[j];
      }
    }
  }

  public void print(int[] array){
    for(int i : array){
      System.out.print(i + " ");
    }
    System.out.println();
  }


  public static void main(String[] args){
    Solution obj = new Solution();
    //int[] array = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
    int[] array = {2,0,1};
    obj.countSmaller(array);
  }



}

