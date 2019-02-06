#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

const int MAXN = 1e6 + 16;
const long long MOD = 1e9 + 7;

long long N;
int X, Y;
int smallest_prime_factor[MAXN];

bool used[MAXN];

inline void sieve_factorization(){

    for( int i=2 ; i <= Y ; i++ )
        smallest_prime_factor[i] = i;
    
    for( int i=4 ; i <= Y ; i+=2 )
        smallest_prime_factor[i] = 2;
    
    for( int i=3 ; i*i <= Y ; i+=2 )
        if( smallest_prime_factor[i] == i ){

            for( int j=i*i ; j<=Y ; j+=i )
                if( smallest_prime_factor[j] == j )
                    smallest_prime_factor[j] = i;
        }
}

inline vector<int> get_factors( int n ){

    int last = smallest_prime_factor[n];
    int cur = 0;
    vector<int> result;

    while( n != 1LL ){

        if( smallest_prime_factor[n] != last ){
            result.push_back(cur);
            last = smallest_prime_factor[n];
            cur = 1;
        }
        else
            cur++;

        n /= smallest_prime_factor[n];
    }

    if( cur )
        result.push_back(cur);

    return result;
}

long long binary_exponentiation( long long b, long long p ){

    if( !p )
        return 1LL;
    if( p == 1LL )
        return b % MOD;
    
    long long half = binary_exponentiation(b, p >> 1);
    half = (half * half) % MOD;

    if( p & 1LL )
        return (half * b) % MOD;
    
    return half;
}

inline long long get_sequences( int lcm, long long n ){

    long long result = 1LL;

    for( auto p : get_factors(lcm) ){

        long long cur = 0LL;
        
        cur = (cur + binary_exponentiation(p + 1LL, N)) % MOD;
        cur = (cur - 2LL * binary_exponentiation(p, N) + 2LL * MOD) % MOD;
        cur = (cur + binary_exponentiation(p - 1LL, N)) % MOD;

        result = (result * cur) % MOD;
    }

    return result;
}

int main(){

    scanf("%d%d%lld", &X, &Y, &N);

    sieve_factorization();

    long long result = 0LL;

    for( long long i=1 ; (Y / i) - X + 1LL > 0LL ; i++ ){

        long long cur = get_sequences(i, N);

        result = (result + (long long)((Y / i) - X + 1LL) * cur) % MOD;
    }

    printf("%lld\n", result);
    return 0;
}