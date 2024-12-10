#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

int main() {
    for (int testCase = 1; testCase <= 10; testCase++) {
        // 암호문의 개수 N
        int N;
        cin >> N;

        // 암호문 배열 입력
        vector<int> cryptogram(N);
        for (int i = 0; i < N; i++) {
            cin >> cryptogram[i];
        }

        // 명령어의 개수 M
        int M;
        cin >> M;

        // 명령어 처리
        vector<pair<string, vector<int>>> commands;
        while (M--) {
            string command;
            cin >> command;

            if (command == "I") { // 삽입 명령어
                int x, y;
                cin >> x >> y;
                vector<int> s(y);
                for (int i = 0; i < y; i++) {
                    cin >> s[i];
                }
                commands.push_back({command, {x, y}});
                commands.back().second.insert(commands.back().second.end(), s.begin(), s.end());
            } else if (command == "D") { // 삭제 명령어
                int x, y;
                cin >> x >> y;
                commands.push_back({command, {x, y}});
            } else if (command == "A") { // 추가 명령어
                int y;
                cin >> y;
                vector<int> s(y);
                for (int i = 0; i < y; i++) {
                    cin >> s[i];
                }
                commands.push_back({command, {y}});
                commands.back().second.insert(commands.back().second.end(), s.begin(), s.end());
            }
        }

        // 명령어 처리
        for (const auto& [command, values] : commands) {
            if (command == "I") {
                int x = values[0];
                int y = values[1];
                for (int i = 0; i < y; i++) {
                    if (x + i < cryptogram.size()) {
                        cryptogram.insert(cryptogram.begin() + x + i, values[2 + i]);
                    }
                }
            } else if (command == "D") {
                int x = values[0];
                int y = values[1];
                for (int i = 0; i < y; i++) {
                    if (x < cryptogram.size()) {
                        cryptogram.erase(cryptogram.begin() + x);
                    }
                }
            } else if (command == "A") {
                for (size_t i = 1; i < values.size(); i++) {
                    cryptogram.push_back(values[i]);
                }
            }
        }

        // 출력
        cout << "#" << testCase << " ";
        for (int i = 0; i < 10; i++) {
            cout << cryptogram[i] << " ";
        }
        cout << endl;
    }

    return 0;
}
