class Solution {
    public int[] transformArray(int[] nums) {
        int[] result=new int[nums.length];

        for(int i = 0, k=nums.length-1; i<nums.length; i++){
            if(nums[i]%2!=0){
                result[k--]=1;
            }

        }
        return result;
        
    }
}
