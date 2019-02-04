#include<bits/stdc++.h>

using namespace std;

int n, m, mark[100005];
vector< int > v[100005];
int ans;

int f(int u, int par) {
	int sum = 1;
	for(auto go: v[u])
	    if(par != go)
	        sum += f(go, u);
    if(u != 1) 
        ans += (sum % 2 == 0);
    return sum;
}
 
int main() {
	scanf("%d", &n);
	for(int i = 1; i <= n - 1; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	} 
	f(1, 0);
	cout << ans << endl;
    
}