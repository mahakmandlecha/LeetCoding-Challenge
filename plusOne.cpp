class Solution {
public:
    vector<int> plusOne(vector<int>& vect) {
     int n=vect.size();
        int carry=0;
        for(int i=n-1;i>=0;i--)     
        {
          int sum =vect[i]+1;
            carry=sum/10;
            vect[i]=sum%10;
            if(carry==0)
                return vect;
        }
        if(carry)
        {
            vect.insert(vect.begin(),carry);
        }
        return vect;
    }
};
