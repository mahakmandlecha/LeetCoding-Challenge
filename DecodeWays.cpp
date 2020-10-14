class Solution {
public:
    int numDecodings(string s) {
        if(s.length() == 0) return 0;
        //vector<int> dp(s.length() + 1, 0);
        int dp[2];
        dp[0] = 1;
        dp[1] = (s[0] == '0') ? 0 : 1;
        
        for(int i = 2; i < s.length() + 1; i++) {
            int res = 0;
            if(s[i-1] != '0') {
                res += dp[1];
            }
            int twoDig = stoi(s.substr(i-2, 2));
            if(twoDig >= 10 && twoDig <= 26) {
                res += dp[0];
            }
            dp[0] = dp[1];
            dp[1] = res;
        }
        return dp[1];
    }
};
