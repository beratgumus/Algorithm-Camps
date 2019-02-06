#include <cstdio>
#include <iostream>

using namespace std;

const int MAXN = 1e5 + 15;

int N, result;
int ar[MAXN]; // numer list
int dp[MAXN]; // dp[i] -> LIS that ends at i. indice

int main(){

    scanf("%d", &N);

    for( int i=0 ; i<N ; i++ )
        scanf("%d", ar + i);

    for( int i=0 ; i<N ; i++ ){

        dp[i] = 1; // Worst case

        for( int j=0 ; j<i ; j++ )
            if( ar[j] < ar[i] && dp[j] + 1 > dp[i] ) // If there is a better LIS that we can attach i. element at the end of it
                dp[i] = dp[j] + 1;
        
        result = max(result, dp[i]);
    }

    printf("%d\n", result);
    return 0;
}