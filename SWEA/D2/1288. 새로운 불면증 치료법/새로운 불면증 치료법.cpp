#include <iostream>
#include <set>
using namespace std;

int main() {
    int tc, n;
    cin >> tc;

    for(int i=1;i<=tc;i++){
        cin >> n;
        set<int> tmp;
        int result = 0;
        while (tmp.size() != 10)
        {
            ++result;
            int middle = n * result;
            while(middle>0){
            int t = middle%10;
            tmp.insert(t);
            middle/=10;
            }
        }
        cout << "#" << i << " " << n*result << endl;
        
    }
    
    return 0;
}