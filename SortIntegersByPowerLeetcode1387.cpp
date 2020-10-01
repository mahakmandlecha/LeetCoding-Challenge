int dp[1000000];
class Solution {
public:
    static bool compare(pair<int, int> p1, pair<int, int> p2) {
        if (p1.second == p2.second) {
            return p1.first < p2.first;
        }
        return p1.second < p2.second;
    }
    int steps(int x) {
        if (x == 1) {
            return 0;
        }
        if (dp[x] == -1) {
            // if x is odd that least significant bit will be 1 else it will be 0
            if (x & 1) {
                dp[x] = steps(3 * x + 1) + 1;
            } else {
                dp[x] = steps(x / 2) + 1;
            }
        }
        return dp[x];
    }
    int getKth(int lo, int hi, int k) {
        memset(dp, -1, sizeof(dp));
        vector<pair<int, int>> ans;

        // moving in powers of 2
        int p = 1;
        for (int i = 0; i <= 15; i++) {
            dp[p << i] = i;
        }

        for (int i = lo; i <= hi; i++) {
            int res = steps(i);
            ans.push_back(make_pair(i, res));
        }

        sort(ans.begin(), ans.end(), compare);

        return ans[k - 1].first;
    }
};
