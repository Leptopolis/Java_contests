class Solution {
    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 257;
    int n;
    long[] suffix;
    long[] prefix;
    long[] powers;

    public String longestPalindrome(String s) {
        int len = 0;
        int ans = -1;
        int iAns = 0;
        int jAns = 0;
        n = s.length();

        prefix = new long[n + 1];
        suffix = new long[n + 1];
        powers = new long[n + 1];

        powers[0] = 1;
        for(int i = 1;i <= n;i++){
            powers[i] = (powers[i - 1] * BASE) % MOD; 
        }

        for(int i = 0;i < n;i++){
            prefix[i + 1] = (prefix[i] * BASE + (s.charAt(i) - 'a' + 1)) % MOD; 
        }

        for(int i = n - 1;i >= 0;i--){
            suffix[i] = (suffix[i + 1] * BASE + (s.charAt(i) - 'a' + 1)) % MOD;
        }

        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(check(i, j)){
                    len = j - i + 1;
                    if(ans < len) {
                        ans = len;
                        iAns = i;
                        jAns = j;
                    }
                }
            }
        }
        String ansStr = s.substring(iAns, jAns + 1);
        //System.out.println(iAns + " " + jAns);
        return ansStr;
    }

    public boolean check(int l, int r){
        long forward = getFHash(l, r);
        long backward = getBHash(l,r);
        return forward == backward;
    }

    private long getFHash(int l, int r) {
        int len = r - l + 1;
        long result = (prefix[r + 1] - prefix[l] * powers[len]) % MOD;
        if (result < 0) result += MOD;
        return result;
    }

    private long getBHash(int l, int r) {
        int len = r - l + 1;
        long result = (suffix[l] - suffix[r + 1] * powers[len]) % MOD;
        if (result < 0) result += MOD;
        return result;
    }

}