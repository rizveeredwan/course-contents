#include <bits/stdc++.h>
using namespace std;

#define MAX 100
#define INF 1000000

vector<int>G[MAX+1],W[MAX+1];
int dist[MAX+1][MAX+1];
int par[MAX+1][MAX+1];

void floyd_warshall(int n){

    for(int k=1; k<=n; k++){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dist[i][j] > (dist[i][k]+dist[k][j])){
                    dist[i][j] = dist[i][k] + dist[k][k];
                    par[i][j] = par[k][j];
                }
            }
        }
    }
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cout<<i<<" to "<<j<<" "<<dist[i][j]<<endl;
        }
        cout<<endl;
    }
}

void path_print(int i, int j){
    if(par[i][j] == -1) {
        cout<<"No path"<<endl;
        return;
    }
    if(path[i][j] == i) {
        cout<<i<<endl;
        return;
    }
    int br = pa[i][j];
    path_print(i, br);
    path_print(br, j);
    return;
}

int main(){
    int n,e;
    cin>>n>>e;
    int a,b,c;
    // initialization
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            dist[i][j] = INF;
            par[i][j] = -1;
        }
        dist[i][i] = 0;
    }
    for(int i=1; i<=e; i++){
        cin>>a>>b>>c;
        G[a].push_back(b);
        W[a].push_back(c);
        if(dist[a][b] > c){ // direct edge weight update considering multi edges
            dist[a][b] = c;
            par[a][b] = a;
        }
    }
    floyd_warshall(n);
    return 0;
}
