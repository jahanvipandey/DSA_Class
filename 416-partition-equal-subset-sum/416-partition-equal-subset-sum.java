class Solution {
    public boolean canPartition(int[] nums) {
        HashMap<String, Boolean> memo = new HashMap<>(); 
        int totalSum = 0;
        
        for(int num : nums)
            totalSum += num;
        
        if(totalSum % 2 != 0)
            return false;
        
        return partition(nums, 0, totalSum/2, memo);
    }
    
    private boolean partition(int[] nums, int currentItem, int targetSum, HashMap<String, Boolean> memo){
        
        if(targetSum == 0)
            return true;
        
        if(currentItem >= nums.length)
            return false;
        
        String currentKey = Integer.toString(currentItem) + "-" + Integer.toString(targetSum);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        boolean consider = false;
        
        if(nums[currentItem] <= targetSum){
            consider = partition(nums, currentItem+1, targetSum - nums[currentItem], memo);
            if(consider == true)
                return true;
        }
            
        boolean notConsider = partition(nums, currentItem+1, targetSum, memo); 
        
        memo.put(currentKey, consider || notConsider);
        
        return memo.get(currentKey);
    }
}