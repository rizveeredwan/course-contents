#include <bits/stdc++.h>
using namespace std;
#define MAX 100
#define INF 100000

vector<int>graph[100],weight[100];
// operator overloading
struct Info{
    int node,cost;
    bool operator < (const Info &a)const {
        if(cost > a.cost) return true;
        return false;
    }
};

void dijkstra(int n, int s){
    int d[MAX];
    int prev[MAX];
    for(int i=1; i<=n; i++){
        d[i] = INF;
        prev[i] = -1;
    }
    d[s] = 0;
    priority_queue<Info>PQ; // max heap: considering smaller values bigger -> big priority
    PQ.push({s,d[s]}); // insertion
    while(PQ.empty() != true){
        Info u = PQ.top(); // O(VlogV)
        PQ.pop();
        if (d[u.node] <= u.cost) continue;
        for(int i=0; i<graph[u.node].size(); i++){ // O(E)
            int v = graph[u.node][i];// adjacency information
            if(d[v]>u.cost+weight[u.node][i]){
                // relaxation
                d[v] = u.cost+weight[u.node][i];
                PQ.push({v, d[v]}); // O(ElogV)
            }
        }
    }

}


int main(void){
    int n,e;
    cin>>n>>e;
    for(int i=0; i<n; i++){
        int a,b,c;
        cin>>a>>b>>c; //2 3 10
        graph[a].push_back(b);// 2: 3
        weight[a].push_back(c);//2: 10
    }
    Info one,two;
    one.node = 1;
    one.cost = 100;
    two.node = 2;
    two.cost = 200;
    cout<< (one < two) <<endl;

}
