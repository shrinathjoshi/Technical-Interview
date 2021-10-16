class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finalresult = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        if(nums.length<4)
            return finalresult;
        
        int n = nums.length;
        int i=0,j=1,k=2,l=n-1;
        boolean isVisited = false;
        
        
        for(i=0;i<n-3;i++){
            j=i+1;    
            for(;j<n-2;j++){
                k=j+1;
                l=n-1;
                
                while(k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum ==target){
                        result.add((Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        k++;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else l--; 
                }
            }
        }
        
        for(List s : result){
            finalresult.add(new ArrayList(s));
        }
        return finalresult; 
    }
}