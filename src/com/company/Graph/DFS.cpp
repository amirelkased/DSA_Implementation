#include <bits/stdc++.h>

using namespace std;

#define KeepGoing          ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

int graph[8][8];
vector<int> path;
int checkVisited[8];

void Depth_First_Search(int init);

int main() {
#ifndef ONLINE_JUDGE
    freopen("IN.txt", "r", stdin);
    freopen("OUT.txt", "w", stdout);
#endif
    KeepGoing
    // take input
    for (int i = 1; i < 8; ++i) {
        for (int j = 1; j < 8; ++j) {
            cin >> graph[i][j];
        }
    }
    int startVertice;
    cin >> startVertice;
    cout << "By DFS: ";
    Depth_First_Search(startVertice);
    for (auto it: path) {
        cout << it << ' ';
    }
    return 0;
}


void Depth_First_Search(int init) {
    if (checkVisited[init] == 0) {
        checkVisited[init] = 1;
        path.push_back(init);
        for (int i = 1; i < 8; ++i) {
            if (graph[init][i] == 1 && checkVisited[i] == 0) {
                Depth_First_Search(i);
            }
        }
    }
}

/*
0 1 1 1 0 0 0
1 0 1 0 0 0 0
1 1 0 1 1 0 0
1 0 1 0 1 0 0
0 0 1 1 0 1 1
0 0 0 0 1 0 0
0 0 0 0 1 0 0

Result: 4 1 3 5 2 6 7
 */