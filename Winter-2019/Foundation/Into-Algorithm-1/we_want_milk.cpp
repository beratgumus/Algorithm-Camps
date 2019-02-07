// Problem: https://www.hackerrank.com/contests/inzva-02-algorithm-1-online-2018/challenges/we-want-milk/problem
// Author: Kadir Emre Oto (keoto)

#include "bits/stdc++.h"

using namespace std;


int main(){
    long long N, M;
    long long a, b;
    scanf("%lld%lld", &N, &M);
  
    vector<pair<long long, long long>> A;
    for (int i=0; i < N; i++){
        scanf("%lld%lld", &a, &b);
        A.push_back({a, b});
    }
  
    sort(A.begin(), A.end());
    long long answer = 0;
  
    for (auto &it : A){
        long long a = it.first;
        long long b = it.second;
    
        answer += a * min(M, b);
    
        M -= b;
        if (M <= 0)
            break;
    }

    printf("%lld\n", answer);
}
