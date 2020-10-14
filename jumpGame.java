class Solution {
    public boolean canReach(int[] arr, int start) {
        HashMap<Integer, Boolean>visited=new HashMap<Integer, Boolean>();
        Queue<Integer>q=new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()){
            if(arr[q.peek()]==0)
                return true;
            if(visited.get(q.peek())!=null){
                q.poll();
                continue;
            }
            if(arr[q.peek()]+q.peek()<arr.length){
                q.add(arr[q.peek()]+q.peek());
            }
            if(q.peek()-arr[q.peek()]>=0){
                q.add(q.peek()-arr[q.peek()]);
            }
            visited.put(q.peek(), true);
            q.poll();
        }
        return false;
    }
}
