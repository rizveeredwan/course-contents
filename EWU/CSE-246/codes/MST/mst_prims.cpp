#include <bits/stdc++.h>
using namespace std;
#define MAX 1000
#define INF 100000000

vector<int>G[MAX+1],W[MAX+1];
bool TreeNode[MAX];
int key[MAX];
int par[MAX];


struct Node{
    int node, cost;
    bool operator < (const Node &a) const {
        if(cost > a.cost) return true;
        return false;
    }
};

void MST_prims(int n){
    priority_queue<Node>PQ;
    for(int i=1; i<=n; i++){
        TreeNode[i] = false; // not selected
        key[i] = INF;
        par[i] = -1;
    }
    PQ.push({1,0});
    key[1] = 0;
    Node temp;
    int result = 0;
    while(PQ.empty() != true){
        temp = PQ.top();
        //cout<<"node "<<temp.node <<" "<<temp.cost<<endl;
        PQ.pop();
        if(TreeNode[temp.node] == false) {
            TreeNode[temp.node] = true;
            result += temp.cost; // equivalent to key[temp.node]
            //cout<<temp.node<<" "<<par[temp.node]<<" "<<temp.cost<<" "<<endl;
        }
        else {
            continue;
        }
        //cout<<"size "<<G[temp.node].size()<<endl;
        for(int i=0; i<G[temp.node].size(); i++){
            //cout<< key[G[temp.node][i]] <<" "<<G[temp.node][i]<<" "<<W[temp.node][i] <<endl;
            if(key[G[temp.node][i]] > W[temp.node][i]){
                key[G[temp.node][i]] = W[temp.node][i];
                PQ.push({G[temp.node][i], key[G[temp.node][i]]});
                par[G[temp.node][i]] = temp.node; //parent
            }
        }
    }
    cout<<"result "<<result<<endl;
    return;
}

void print_mst(int n){
    for(int i=1; i<=n; i++){
        if(par[i] != -1) {
            cout<<i<<" "<<par[i]<<endl;
        }
    }
}

/*
4 6
1 2 2
1 3 1
1 4 10
2 3 5
2 4 10
3 4 3


*/

int main(void){
    //freopen("in.txt", "r", stdin);
    int n,e;
    cin>>n>>e;
    cout<<n<<" "<<e<<endl;
    int a,b,c;
    for(int i=0; i<e; i++){
        cin>>a>>b>>c;
        cout<<a<<" "<<b<<" "<<c<<endl;
        G[a].push_back(b);
        G[b].push_back(a);
        W[a].push_back(c);
        W[b].push_back(c);
    }
    MST_prims(n);
    print_mst(n);
    return 0;
}
