class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0, target, nums, new HashMap<String, Integer>());
    }
    
    private int ways(int currentIndex, int target, int[] nums, HashMap<String, Integer> memo){
        if(target == 0 && currentIndex == nums.length)
            return 1;
        
        if(currentIndex >= nums.length)
            return 0;
        
        String key = Integer.toString(currentIndex) + "-" + Integer.toString(target);
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int add = ways(currentIndex+1, target - nums[currentIndex], nums, memo);
        int subtract = ways(currentIndex+1, target + nums[currentIndex], nums, memo);
        
        memo.put(key, add + subtract);
        
        return memo.get(key);
    }
}