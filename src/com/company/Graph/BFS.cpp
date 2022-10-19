#include <bits/stdc++.h>

using namespace std;

int graph[8][8];
deque<int> verticeQueue;

vector<int> Breadth_First_Search(int init) {
    // initialization
    vector<int> path;
    int checkVisited[8];
    verticeQueue.push_back(init);
    path.push_back(init);
    checkVisited[init] = 1;

    // Explore
    while (!verticeQueue.empty()) {
        for (int i = 1; i < 8; ++i) {
            if (graph[verticeQueue.front()][i] == 1 && checkVisited[i] != 1) {
                verticeQueue.push_back(i);
                checkVisited[i] = 1;
                path.push_back(i);
            }
        }
        verticeQueue.pop_front();
    }
    return path;
}

int main() {
    // take input
    for (int i = 1; i < 8; ++i) {
        for (int j = 1; j < 8; ++j) {
            cin >> graph[i][j];
        }
    }
    int startVertice;
    cin >> startVertice;
    for (auto it: Breadth_First_Search(startVertice)) {
        cout << it << ' ';
    }
    return 0;
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