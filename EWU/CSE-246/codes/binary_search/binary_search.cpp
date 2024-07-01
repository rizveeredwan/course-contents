# include <bits/stdc++.h>
using namespace std;

int _binary_search(vector<int>arr, int sr) {
    // # Given an array, find the index after which sr will be placed
    int st = 0, en = arr.size()-1, mid;
    while (st < en) {
        cnt++;
       if (en-st <= 1) {
            if (en<sr) {
                return (en+1);
            }
            if (st<sr) {
                return (st+1);
            }
       }
       mid = (st+en)/2;
        if (sr < arr[mid]) {
            en = mid-1;
        }
        else {
            st = mid;
        }
    }
}

int main(void){

}
