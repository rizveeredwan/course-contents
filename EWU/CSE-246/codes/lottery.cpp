#include <bits/stdc++.h>
using namespace std;
#define MAX 20

void lottery(int number_of_groups, int number_of_problems){
    assert(number_of_problems>=number_of_groups);
    bool flag[MAX+1];
    int idx;
    for(int i=1; i<=number_of_problems; i++) flag[i] = false;
    for(int i=1; i<=number_of_groups; i++){
        while(true){
            idx = rand()%number_of_problems+1;
            if(flag[idx] == false) {
                flag[idx] = true;
                break;
            }
        }
        cout<<"Group "<<i<<": "<<idx<<endl;
        getchar();
    }
}

int main(void){
    srand(time(nullptr));
    lottery(11,15);
}
