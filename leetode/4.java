class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] narr = new int[n + m];
        int l = 0;
        int r = 0;
        int t = 0;
        while(l < n && r < m){
            if(nums1[l] < nums2[r]){
                narr[t] = nums1[l];
                l++;
                t++;
            }else{
                narr[t] = nums2[r];
                r++;
                t++;
            }
            
        }

        if(l != n){
            while(l < n){
                narr[t] = nums1[l];
                l++;
                t++;
                
            }
        } 
        if(r != m){
            while(r < m){
                narr[t] = nums2[r];
                r++;
                t++;
            }
        }
        
        if((n + m) % 2 == 0){
            double a = narr[(n + m)/2 - 1];
            double b = narr[(n + m) / 2];
            System.out.println(a + " " + b);
            return (a + b)/2;
        }else{
            return narr[(n + m) / 2];
        }
    }
}