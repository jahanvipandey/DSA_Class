class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        
        for(int currentNum : nums1){
            if(!memo.containsKey(currentNum))
                memo.put(currentNum, true);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int currentNum : nums2){
            if(memo.containsKey(currentNum) && memo.get(currentNum)){
                ans.add(currentNum);
                memo.put(currentNum, false);
            }
        }
        int[] result = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}