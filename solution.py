class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        stepInt = {}
        def getPower(n):
            steps=0
            ints=[n]
            while n>1:
                if n%2==0: n/=2
                else: n=n*3+1
                steps+=1
                if n in stepInt:
                    x = stepInt[n]
                    for i,num in enumerate(reversed(ints)):
                        stepInt[num]=i+1+x
                    return x+steps
                ints.append(n)
            for i,num in enumerate(reversed(ints)):
                stepInt[num]=i
            return steps
        result = sorted(list(range(lo,hi+1)),key=lambda x: (getPower(x),x))
        return result[k-1]        