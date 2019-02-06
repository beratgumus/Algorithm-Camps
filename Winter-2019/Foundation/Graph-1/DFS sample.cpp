#include<bits/stdc++.h>
 
using namespace std;
 
int n, m, mark[199999];
vector< int > v[100000];
int ans;
 
void dfs(int node) {
    mark[node] = 1;
    for(auto go: v[node])
        if(mark[go] == 0)
            dfs(go);
}
 
int main() {
	scanf("%d %d", &n, &m);
	for(int i = 1; i <= m; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	} 
 
    int ans = 0;
    for(int i = 1; i <= n; i++)
        if(mark[i] == 0) {
            ans++;
            dfs(i);
        }
    printf("%d\n", ans);
}