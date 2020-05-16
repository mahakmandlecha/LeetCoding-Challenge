class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int num[]= new int[256];
        
        if (ransomNote==null || ransomNote.length() == 0) return true;
        if (magazine==null || magazine.length() == 0) return false;
        
        for(char c: magazine.toCharArray())
            num[c]++;
        for(char c: ransomNote.toCharArray())
        {
            if(num[c]==0)
                return false;
            num[c]--;
        }
        return true;
    }
}




    
        
