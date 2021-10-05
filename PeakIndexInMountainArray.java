class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;

        int end = arr.length - 1;

        while(start < end) {
            int middle = start + (end - start) / 2;
          
            //if middle element is bigger than its next element, there is a possibility that the peak is the middle element OR the element before that
            
            if(arr[middle] > arr[middle + 1]) { 
                end = middle;
            }
            
            //if middle element is lesser than its next element, we know that the peak will be after middle element
            
            else {
                start = middle + 1;
            }
        }

        return start;
    }
}
