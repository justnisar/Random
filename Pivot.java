class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        if(length == 0)
            return -1;
        if(length == 1)
            return nums[0];
        int totalSum = 0;
        for(int i : nums)
            totalSum += i;
        int currentSum = 0;
        for(int i = 0 ; i < length ; i++){
            currentSum += nums[i];
            int leftSum = currentSum - nums[i];
            int rightSum = totalSum - currentSum;
            //System.out.println("Left : " + leftSum);
            //System.out.println("Right : " + rightSum);
    
            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }
}
