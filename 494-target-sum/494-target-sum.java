class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums, 0, target, new HashMap<String, Integer>());
    }
    
    private int targetSum(int[] nums, int currentItem, int target, HashMap<String, Integer> memo){
        if(currentItem == nums.length && target == 0)
            return 1;
        
        if(currentItem == nums.length && target != 0)
            return 0;
        
        String key = Integer.toString(currentItem) + "-" + Integer.toString(target);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int plusSign = targetSum(nums, currentItem+1, target - nums[currentItem], memo);
        int minusSign = targetSum(nums, currentItem+1, target + nums[currentItem], memo);
        
        memo.put(key, plusSign + minusSign);
        return memo.get(key);
    }
}