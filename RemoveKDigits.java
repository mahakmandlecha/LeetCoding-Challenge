class Solution {
    public String removeKdigits(String num, int k) {
        int count = 0;
        StringBuilder s = new StringBuilder();
        if(num.length()==k) {
        	return "0";
        }
        for (char c:num.toCharArray()) {
        	while (s.length()!= 0 && s.charAt(s.length()-1)>c && count<k) 
            {
        		s.deleteCharAt(s.length()-1);
        		++count;
        	}
        	if (c!='0' ||s.length()!=0) 
        		s.append(c);
        }
        if (s.length()==0) {
        	return "0";
        }
        return s.substring(0,s.length()-k+count);
    }
}
