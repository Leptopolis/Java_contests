class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i < n - 2;i++){
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> nb = new ArrayList<>();
                    nb.add(nums[i]);
                    nb.add(nums[l]); 
                    nb.add(nums[r]);
                    ans.add(nb);
                    l++;
                    r--; 
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else{
                    r--;
                }                
            }
        }
        List<List<Integer>> ans1 = new ArrayList<>(ans);
        return ans1;
    }
}