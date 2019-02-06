#include<bits/stdc++.h>

using namespace std;

const int limit = 100005;

typedef pair<int,int> ii;
typedef pair<ii,int> iii;

struct node {
	int u, cost, back;
	node( int _u=0, int _cost=0, int _back=0 ) {
		u = _u;
		cost = _cost;
		back = _back;
	}

	friend bool operator < ( const node &a, const node &b ) {
		return a.cost > b.cost;
	}

};

// first == destination
// second == weight
vector< pair<int,int> > adj[limit];

// answer of each node ==>>>>> minimum length of the path from s, to x == ans[x]
int ans[limit];

int n, m, s, f; 

int calc_dijkstra() {

	// first == cost of the path
	// second == last node of the path
	priority_queue<ii, vector<ii>, greater<ii> > q;

	q.push( ii( 0, s ) );

	for(int i=0;i<n;i++) ans[i] = -1;

	while( !q.empty() ) {
		int cost = q.top().first; 	// cost == cost of the path
		int u = q.top().second;		// u == last node of the path
		q.pop();

		if( ans[u] != -1 ) continue;
		ans[u] = cost;
		for(int i=0;i<adj[u].size();i++) {
			int v = adj[u][i].first;		// v == destination of the edge
			int w = adj[u][i].second;		// w == weight of the edge
			q.push( ii( cost + w, v ) );
		}

	}
	return ans[f];
}

int visited[limit];

struct heap {

	vector<node> v;

	heap() {
		v.clear();
	}

	int getmax( int k ) {
		if( k+k+1 >= v.size() ) return -1;
		if( k+k+2 >= v.size() ) return k+k+1;
		if( v[k+k+1] < v[k+k+2] ) return k+k+2;
		return k+k+1;
	}

	void push( node x ) {
		v.push_back( x );
		int p = v.size()-1;
		while( p > 0 ) {
			if( v[ (p-1)/2 ] < v[p] )
				swap( v[ (p-1)/2 ], v[p] );
			p = (p-1)/2;
		}
	}

	void pop() {
		v[0] = v[ v.size()-1 ];
		v.pop_back();
		int k = 0;
		while( getmax( k ) != -1 ) {
			int mx = getmax( k );
			if( !(v[mx] < v[k]) ) // v[mx] > v[k] is incorrect because '>' isn't defined.
				swap( v[mx], v[k] );
			k = mx;
		}
	}

	node top() {
		return v[0];
	}

	bool empty() {
		return v.size() == 0;
	}

};

vector<ii> calc_MST() {

	// first == cost of the potential edge
	// second == id of the potential edge
	priority_queue<node> q;
	// heap q;

	q.push( node( 0, s, -1 ) );

	vector<ii> ret;
	
	for(int i=0;i<n;i++) visited[i] = -1;
	
	while( !q.empty() ) {
		int cost = q.top().cost; 		// cost == cost of the potential edge
		int u = q.top().u;				// u == id of the potential edge
		int back = q.top().back;		// back == parent of the potential edge
		q.pop();

		if( back != -1 ) ret.push_back( ii( u, back ) );

		if( visited[u] != -1 ) continue;
		visited[u] = 12837;

		for(int i=0;i<adj[u].size();i++) {
			int v = adj[u][i].first;		// v == destination of the edge
			int w = adj[u][i].second;		// w == weight of the edge
			q.push( node( w, v, u ) );
		}

	}
	return ret;
}

int main() {

	// s == start
	// f == finish

	scanf("%d %d %d %d",&n,&m,&s,&f);
	for(int i=0;i<m;i++) {
		int u, v, c;
		scanf("%d %d %d",&u,&v,&c);
		adj[u].push_back( ii( v, c ) );
		adj[v].push_back( pair<int,int>( u, c ) );
	}

	calc_dijkstra();

	calc_MST();

	return 0;
}
