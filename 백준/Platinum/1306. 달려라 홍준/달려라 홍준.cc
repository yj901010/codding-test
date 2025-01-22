#include <iostream>
#include <vector>

using namespace std;
int N,M;
vector<int> arr;
vector<int> tree;

int init(int start, int end, int node){
    if (start==end) {
        return tree[node] = arr[start];
    }
    int mid = (start+end) / 2;
    return tree[node] = max(init(start,mid, node*2), init(mid+1,end,node*2+1));
}

int query(int start, int end, int node, int leftNode, int rightNode){
    if (rightNode < start || end < leftNode) {
        return 0;
    }
    if (start <= leftNode && rightNode <= end){
        return tree[node];
    }
    int mid = (leftNode+rightNode) / 2;
    return max(query(start,end,node*2,leftNode,mid), query(start,end,node*2+1,mid+1,rightNode));
}


int main()
{
    cin >> N >> M;
    
    arr.resize(N);
    for (int i=0;i<N;i++){
        cin >> arr[i];
    }
    tree.resize(N*4);
    init(0,N-1,1);
    for (int i=M-1;i<=N-M;i++){
        int st = i-M+1;
        int ed = i+M-1;
        cout << query(st,ed,1,0,N-1) << " ";
    }

    return 0;
}