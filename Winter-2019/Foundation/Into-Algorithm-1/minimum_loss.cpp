// Problem: https://www.hackerrank.com/challenges/minimum-loss/problem
// Author: Kadir Emre Oto (keoto)

#include "bits/stdc++.h" 

using namespace std;


int main(int argc, char const *argv[]){
    int N;
    scanf("%d", &N);

    set<long long> L;
    long long ans = 1e17, x;

    for (int i=0; i < N; i++){
        scanf("%lld", &x);

        if (i == 0){
            L.insert(x);
            continue;
        }

        auto it = L.upper_bound(x);
        if (*it > x and ans > *it - x)
            ans = *it - x;
        L.insert(x);
    }    

    printf("%lld\n", ans);
}
