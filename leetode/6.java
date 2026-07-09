class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        int[] used = new int[n];

        int t = 0;
        int k = 0;
        for(int i = 0;i < n;i++){
            used[i] = t;
            k++;
            System.out.println(used[i] + " " + s.charAt(i));
            if(t% 2 == 0 && k % numRows == 0){
                k = 0;
                t++;
            }
            else if(t%2 == 1 && k % (numRows - 2) == 0){
                k = 0;
                t++;
            }
            
        }

        String ans = "";
        
        for(int i = 0;i < numRows;i++){
            k = 0;
            ans += s.charAt(i);
            while(){
                
            }
        }
        return ans;
    }
}


/*
4
P     I    N
A   L S  I G
Y A   H R
P     I

3
P   A   H   N
A P L S I I G
Y   I   R

5
1 & last string: 2n - 3
2 & last - 1 strng: if(i % 2 == 0) n - 2 + n  - 3
                    else 1
for i: 0 n - 1 2n -3:
t = 0;

for(int i = 0;i < n;i++){
    if((i + 1 + t) % m  == 0) t ++;
    used[i] = t;
}

for(int i = 0;i < n;i++){
    for(int j = 0;j < n;j++){
        if(used[j] == i) ans += s[j];
    }
}
P       H
A     S I
Y   I   R
P L     I g
A       N
*/