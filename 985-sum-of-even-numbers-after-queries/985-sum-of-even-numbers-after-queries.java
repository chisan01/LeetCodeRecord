class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int sumOfEvenValues = 0;
        for(int num : nums) {
            if(num%2 != 0) continue;
            sumOfEvenValues += num;
        }
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            boolean beforeEven = nums[index]%2 == 0;
            boolean valEven = val%2 == 0;
            
            if(beforeEven) {
                if(valEven) sumOfEvenValues += val;
                else sumOfEvenValues -= nums[index];
            } else if(!valEven) {
                sumOfEvenValues += nums[index] + val;
            }
            nums[index] += val;
            
            answer[i] = sumOfEvenValues;
        }
        
        return answer;
    }
}