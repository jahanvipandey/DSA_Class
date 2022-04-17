class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atmostk = kDifferentInteger(nums, k);
        int atmostk1 = kDifferentInteger(nums, k-1);
        
        System.out.println(atmostk);
        System.out.println(atmostk1);
        
        return atmostk - atmostk1;
    }
    
    public int kDifferentInteger(int[] nums, int k){
        HashMap<Integer, Integer> memo = new HashMap<>();
        int distinct = 0; 
        int release = 0;
        int answer = 0;

        for(int acquire = 0; acquire < nums.length; acquire++){
            int currentNum = nums[acquire];
            if(memo.containsKey(currentNum)){
                memo.put(currentNum, memo.get(currentNum) + 1);
            } else {
                memo.put(currentNum, 1);
                distinct += 1;
            }

            while(release <= acquire && distinct > k){
                int disNum = nums[release];
                memo.put(disNum, memo.get(disNum) - 1);
                release += 1;

                if(memo.get(disNum) == 0){
                    memo.remove(disNum);
                    distinct -= 1;
                }
            }
            answer += acquire - release + 1;
        }
        return answer;
    }
}