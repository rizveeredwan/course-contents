#include <bits/stdc++.h>
using namespace std;

void prime_bruteforce(int n){ // O(n)
    for(int i=n-1; i>=2; i--){
        if(n%i == 0) {
            cout<<"N P"<<endl;
            return;
        }
    }
    cout<<"P"<<endl;
}

void prime_bruteforce2(int n){ // O(n)
    for(int i=2; i<=n; i++){
        if(n%i == 0) {
            cout<<"N P"<<endl;
            return;
        }
    }
    cout<<"P"<<endl;
}

void prime_bruteforce3(int n){ // O(n)
    for(int i=2; i<=n/2; i++){
        if(n%i == 0) {
            cout<<"N P"<<endl;
            return;
        }
    }
    cout<<"P"<<endl;
}

void prime_opti(int n){ // O(sqrt(n))
    int bound = sqrt(n);
    for(int i=2; i<=bound; i++){
        if(n%i == 0) {
            cout<<"N P"<<endl;
            return;
        }
    }
    cout<<"P"<<endl;
}

int main(void){

}
