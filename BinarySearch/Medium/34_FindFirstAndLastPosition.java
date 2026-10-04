class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []ans= new int[2];
        int n=nums.length;
        if(n==0) return new int[]{-1,-1};
                              
       int firstOccurance=-1; 
       int start=0;           
       int end=n-1;           
                          
       while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]>=target){
            firstOccurance=mid;
            end=mid-1;
        }else{
            start=mid+1;
        }
      }
      // for this 1st occurrance should exists 
      if(firstOccurance==-1 || nums[firstOccurance]!=target){
        return new int[]{-1,-1};
      }
        ans[0]=firstOccurance;
        int secondOccurance=-1;
        start=0;
        end=n-1;

        while(start<=end){
            int mid=start + (end-start)/2;
            if(nums[mid]>target){           
                end=mid-1;
            }else{
                secondOccurance=mid;
                start=mid+1;
            }
        }
        ans[1]=secondOccurance;
        return ans;
    }
}
