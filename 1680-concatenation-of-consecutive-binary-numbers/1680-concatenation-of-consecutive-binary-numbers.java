class Solution {
    
    final int MOD = 1000000007;
    
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        
        String num = sb.toString();
        long result = 0;
        for(int i=0; i<num.length(); i++) {
            result = (result * 2) % MOD;
            result = (result + (num.charAt(i) - '0')) % MOD;
        }
        return (int) result;
    }
}