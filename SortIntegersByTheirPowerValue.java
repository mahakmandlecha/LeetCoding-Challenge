class Solution {
    TreeMap<Integer, ArrayList<Integer>>map2=new TreeMap<Integer, ArrayList<Integer>>();
    HashMap<Integer, Integer>map=new HashMap<Integer, Integer>();
    public int getKth(int lo, int hi, int k) {
        
        map.put(1,0);
        for(int i=lo; i<=hi; i++){
            if(map.get(i)==null)
                getRecursively(i, true);
            else{
            if(map2.get(map.get(i))!=null){
                ArrayList<Integer>n=map2.get(map.get(i));
                n.add(i);
                map2.put(map.get(i), n);
            }
            else{
                ArrayList<Integer>n=new ArrayList<Integer>();
                n.add(i);
                map2.put(map.get(i), n);
            }  
            }
        }
        int k2=0;
        int count=0;
        for(int i:map2.keySet()){
            k2+=map2.get(i).size();
            count=i;
            if(k2>=k){
                break;
            }
        }
        
        return map2.get(count).get(map2.get(count).size()-1+k-k2);
        
    }
    public int getRecursively(int val, boolean addToMap){
        if(map.get(val)!=null)
            return map.get(val);
        if(val%2==0){
            int ret=getRecursively(val/2, false)+1;
            map.put(val, ret);
            if(addToMap){
            if(map2.get(ret)!=null){
                ArrayList<Integer>n=map2.get(ret);
                n.add(val);
                map2.put(ret, n);
            }
            else{
                ArrayList<Integer>n=new ArrayList<Integer>();
                n.add(val);
                map2.put(ret, n);
            }  
        }
            return ret;
        }
        else{
            int ret=getRecursively(val*3+1, false)+1;
            map.put(val, ret);
            if(addToMap){
            if(map2.get(ret)!=null){
                ArrayList<Integer>n=map2.get(ret);
                n.add(val);
                map2.put(ret, n);
            }
            else{
                ArrayList<Integer>n=new ArrayList<Integer>();
                n.add(val);
                map2.put(ret, n);
            }  
        }
            return ret;
        }
    }
}
