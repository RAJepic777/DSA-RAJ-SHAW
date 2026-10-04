class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(n<k) return -1;

        int max=0;
        int sum=0;
        for(int x:nums){
            max=Math.max(max,x);
            sum+=x;
        }
        int start=max;
        int end=sum;

            int ans=0;
        while(start<=end){
            int mid=start + (end-start)/2;
           boolean isFlag=check(nums,mid,k);
                if(isFlag){
                     ans=mid;
                     end=mid-1;   
                }else{
                    start=mid+1;
                }

        }
        return ans;
        
    }
    public boolean check(int [] num,int split, int k){
        int count=0;
        int sum=0;
        for(int x:num){
              sum+=x;
              if(sum==split){
                count++;
                sum=0;
              }else if(sum>split){
                count++;
                sum=x;
              }  
        }
        if(sum>0 && sum<=split){
            count++;
        }
        if(count <=k){
            return true;
        }
        return false;
    }
}
