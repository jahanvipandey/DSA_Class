class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(freqMap.containsKey(nums[i])){
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            } else {
                freqMap.put(nums[i], 1);
            }
        }
        
        Arrays.sort(nums);
        int n = nums[(nums.length)-1];
        
        int[] freqArr = new int[n+1];
        
        for(int i = 0; i < n+1; i++)
            freqArr[i] = 0;
        
        // for(int i = 0; i < n+1; i++)
        //     System.out.print(freqArr[i]);
        
        for(Map.Entry entry : freqMap.entrySet()){
            freqArr[(int)entry.getKey()] = (int)entry.getValue();
            //System.out.println(entry.getKey() + " " + entry.getValue());
        } 
        
        // for(int i = 0; i < n+1; i++)
        //     System.out.println(i+" "+freqArr[i]);
        
        return maximize(0, freqArr, nums, new HashMap<Integer, Integer>());
    }
    
    private int maximize(int currentIndex, int[] freqArr, int[] nums, HashMap<Integer, Integer> memo){
        if(currentIndex >= freqArr.length)
            return 0;
        
        int key = currentIndex;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = (currentIndex*freqArr[currentIndex]) + maximize(currentIndex + 2, freqArr, nums, memo);
        int notConsider = maximize(currentIndex + 1, freqArr, nums, memo);
        
        memo.put(key, Math.max(consider, notConsider));
        return memo.get(key);
    }
}