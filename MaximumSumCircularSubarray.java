class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int no=maxSum(A);
        if(no<0)
            return no;
        int s=0;
        for(int i=0;i<A.length;i++)
        {
            s+=A[i];
            A[i]= -A[i];
        }
        int maxC=s+maxSum(A);
        return Math.max(no,maxC);
        
      
    }
    
    
    
    int maxSum(int arr[]){
        int res=arr[0],max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            max=Math.max(arr[i],max+arr[i]);
            res=Math.max(res,max);
        }
        return res;
    } 
}
