class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int ans = 0;
        int start = 0;
        int[] arr = new int[256];
        for(int i = 0;i < 256;i++) arr[i] = -1;

        for(int i = 0;i < s.length();i++){
            int sym = s.charAt(i);
            if(arr[sym] < start){
                //System.out.println(i + "i");
                arr[sym] = i;
                len++;
            }
            else{
                start = arr[sym] + 1;
                //System.out.println(len);
                if(ans < len) ans = len;
                len = i - arr[sym];
                //for(int j = 0;j < 256;j++) arr[j] = -1;
                if(ans < len) ans = len;
                
                arr[sym] = i;
            }
        }

        if(ans < len) ans = len;
        return ans;
    }
}