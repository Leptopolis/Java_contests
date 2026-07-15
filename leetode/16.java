class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        int ans = nums[0] + nums[1] + nums[2];
        int dist = Math.abs(target - nums[0] - nums[1] - nums[2]);

        Arrays.sort(nums);
        for(int i = 0;i < n - 2;i++){
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target) {
                    l++;
                }else if(sum > target){
                    r--;
                }else{
                    return sum;
                }
                if(Math.abs(target - sum) < dist){
                    dist = Math.abs(target - sum);
                    ans = sum;
                }
            }
        }
        return ans;
    }
}