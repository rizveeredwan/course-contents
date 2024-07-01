#include <bits/stdc++.h>
using namespace std;

struct Info {
    int a;
    int b;
    /* comparing this object with respect to another object el */
    // an example of operator overloading
    bool operator < (const Info &el){ // writing the definition of < (less than) operator
        if(a>el.a) return true; // this object's a attribute is less than el object's a attribute
        if(a == el.a) {
            if(b>el.b) return true;
            return false;
        }
        return false;
        // return true means, current object is smaller compared to el,
        // return false means, current object is bigger than current object el
        // by definition, in a sorted list of elements, small entity comes before larger entity
    }
};
// Another way to execute the same functionality
/*bool cmp(Info el1, Info el2){
    if (el1.a < el2.a) return true;
    if(el1.a == el2.a){
        if(el1.b< el2.b) return true;
        return false;
    }
    else return false;
}*/

void print(vector<Info>V){
    for(int i=0; i<V.size(); i++){
        cout<<V[i].a<<" "<<V[i].b<<endl;
    }
    return;
}

int main(void){
    srand(time(nullptr));
    int n;
    cin>>n;
    vector<Info>V; // declaration of a vector, that contains Info (custom datatype) elements
    for(int i=0; i<n; i++){
        Info temp;
        temp.a = rand()%50;
        temp.b = rand()%20;
        V.push_back(temp); // inserting an element at the end of the vector
    }
    // vector accessing example, V[0] means accessing 0th index
    /*
        - comparing V[0](base element) with respect to V[1](compared element)
        - when written, this calls the operator overloading function written
        to compare two info type elements
    */
    cout<<(V[0]<V[1])<<endl;
    // print)
    cout<<endl<<"before sorting "<<endl;
    print(V);
    sort(V.begin(),V.end()); // in built sorting syntex
    cout<<endl<<"after sorting "<<endl;
    print(V);
    return 0;
}
