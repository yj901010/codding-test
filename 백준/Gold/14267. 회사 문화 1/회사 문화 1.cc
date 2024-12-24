#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

void dfs(int node, const vector<vector<int>>& tree, vector<int>& praises){
    for(int child: tree[node]){
        praises[child] += praises[node];    
        dfs(child, tree, praises);
    }
}

int main()
{
    int n, m;
    cin >> n >> m;
    
    vector<int> parent(n+1, 0);
    vector<vector<int>> tree(n+1);
    for(int i=1;i<=n;i++){
        cin >> parent[i];
        if(parent[i] != -1){
            tree[parent[i]].push_back(i);
        }
    }
    
    vector<int> praises(n + 1, 0);
    
    for (int i = 0; i < m; ++i) {
        int i_num, w;
        cin >> i_num >> w;
        praises[i_num] += w;
    }
    
    dfs(1, tree, praises);
    
    for (int i = 1; i <= n; ++i) {
        cout << praises[i] << " ";
    }
    cout << endl;
    
    return 0;
}