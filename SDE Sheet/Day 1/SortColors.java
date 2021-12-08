class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n-1;
        int current = 0;
        
        while(current<=last){
            if(nums[current]==2){
                int temp = nums[last];
                nums[last]=nums[current];
                nums[current]=temp;
                last--;
            }
            else if(nums[current]==0){
                int temp = nums[current];
                nums[current]=nums[first];
                nums[first]=temp;
                first++;
                current = Math.max(current,first);
            }
            else current++;
        }
    
        
    }
}

//Time complexity :- O(n)
//Space complexity :-O(1)