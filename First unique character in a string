class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}


