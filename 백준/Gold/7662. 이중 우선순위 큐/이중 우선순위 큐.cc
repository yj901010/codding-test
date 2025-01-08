#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    int T;
    cin >> T;
    
    for (int tc=0;tc<T;tc++){
        int k;
        cin >> k;
        map<int, int> q;
        
        for (int i=0;i<k;i++){
            char c;
            int v;
            cin >> c >> v;
            
            if ( c == 'I'){
                q[v]++;
            } else {
                if (q.empty()) {
                    continue;   
                }
                if ( v == 1 ){
                    auto last = --q.end();
                    if (last->second > 1) {
                        last->second--;
                    } else if (last->second == 1) {
                        q.erase(last);
                    }
                } else {
                    auto first = q.begin();
                    if (first->second > 1) {
                        first->second--;
                    } else if (first->second == 1) {
                        q.erase(first);
                    }
                }
            }
        }
        
        if (q.empty()){
            cout << "EMPTY" << "\n";
        } else {
            cout << (--q.end())->first << " " << q.begin()->first << "\n";
        }
    }
    

    return 0;
}
