#include <iostream>
using namespace std;

int main() {
    int tc, n, m;
    cin >> tc;
    
    for (int i=1;i<=tc;i++){
        cin >> n >> m;
        
        int mask = (1 << n) - 1;
        if((m&mask) == mask){
            cout << "#" << i << " " << "ON" << endl;
        } else {
            cout << "#" << i << " " << "OFF" << endl;
        }
    }
    
    return 0;
}