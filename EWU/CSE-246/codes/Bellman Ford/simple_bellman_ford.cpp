#include <bits/stdc++.h>
using namespace std;
#define MAX 100
#define INF 1000000000

struct Edges{
    int u,v,w;
};

vector<Edges>edges; // to store all the edges
int dist[MAX+1];
int par[MAX+1];

void bellman_ford(int n, int src){
    for(int i=1; i<=n; i++){ // considering 1 based indexing
        dist[i] = INF; // infinite distance
        par[i] = -1; // no parent
    }
    dist[src] = 0;
    bool update = false;
    for(int itr=1; itr<=(n-1); itr++){
        update = false; // let us consider that there will be no update
        for(int i=0; i<edges.size(); i++){ // relaxation
            if(dist[edges[i].v] > dist[edges[i].u]+edges[i].w){
                update= true;
                dist[edges[i].v] = dist[edges[i].u]+edges[i].w;
                par[edges[i].v] = edges[i].u;
            }
        }
        if(update == false) {
            break; // no update, early stopping
        }
    }
    if(update == true){ // there might be cycle
        update = false; // let us consider that there will be no update
        for(int i=0; i<edges.size(); i++){ // relaxation
            if(dist[edges[i].v] > dist[edges[i].u]+edges[i].w){
                update= true;
                dist[edges[i].v] = dist[edges[i].u]+edges[i].w;
                par[edges[i].v] = edges[i].u;
                break;
            }
        }
        if(update == true){
            cout<<"Negative cycle exists"<<endl;
        }
    }
    if(update == false){
          for(int i=1; i<=n; i++){
                cout<<"distance from "<<src<<" to "<<i<<" : " << dist[i]<<endl;
        }
    }
    return;
}

/*
4 7
1 2 10
1 3 2
3 2 1
2 4 1
4 3 2
2 3 1
1 4 5
1
*/

int main(void){
    int n,e; // node, edges
    cin>>n>>e;
    int a,b,c;
    for(int i=0; i<e; i++){
        cin>>a>>b>>c;
        edges.push_back({a, b, c}); // considering directed edge (a->b with weight c)
    }
    int src;
    cin>>src;
    bellman_ford(n, src);
    return 0;

}
