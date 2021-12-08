class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int totalMax = nums[0];
        int currentMax = nums[0];
        
        for(int i=1;i<n;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            totalMax = Math.max(totalMax,currentMax);
        }
        
        return totalMax;
    }
}

//Time Complexity :- O(n)
//Space Complexity :- O(1)