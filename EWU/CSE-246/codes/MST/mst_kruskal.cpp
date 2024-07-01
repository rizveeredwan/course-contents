#include <bits/stdc++.h>
using namespace std;
#define MAX 50

struct Info{
    int a,b,c;
    bool operator < (const Info &a) const {
        if(c < a.c) return true;
        return false;
    }
};

int par[MAX];

int find_set(int a){
    if(a == par[a]) return a;
    par[a] = find_set(par[a]);
    return par[a];
}

void kruskal(vector<Info>V, int n){
    for(int i=1; i<=n; i++) {
        par[i] = i;
    }
    sort(V.begin(), V.end());
    int a,b;
    int cost = 0;
    for(int i=0; i<V.size(); i++){
        a = V[i].a;
        b = V[i].b;
        if(find_set(a) != find_set(b)) {
            cost += V[i].c;
            par[b] = par[a];
        }
    }
    cout<<cost<<endl;
    return;
}

/*
4 5
1 2 1
1 4 10
1 3 1
2 3 10
2 4 1
*/

int main(void){
    int n,e;
    cin>>n>>e;
    int a,b,c;
    vector<Info>V;
    for(int i=0; i<e; i++){
        cin>>a>>b>>c;
        V.push_back({a, b, c});
    }
    sort(V.begin(), V.end());
    kruskal(V, n);
    return 0;
}
