#include <bits/stdc++.h>
using namespace std;

struct HuffmanNode {
    string s;
    int freq;
    bool bit;
    HuffmanNode* left=NULL;
    HuffmanNode* right=NULL;
};

// this is an structure which implements the
// operator overloading
struct CompareNodes {
    bool operator()(HuffmanNode* const& p1, HuffmanNode* const& p2)
    {
        // return "true" if "p1" is ordered
        // before "p2", for example:
        return p1->freq > p2->freq;
    }
};

priority_queue<HuffmanNode*, vector<HuffmanNode*>, CompareNodes>PQ;

void print_pq(){
    HuffmanNode* h;
    while (PQ.empty()!= true){
        h = PQ.top();
        cout<< h->s << " " << h->freq << endl;
        PQ.pop();
    }
    return;
}

int input(){
    int n;
    cin>>n;
    string s;
    int freq;
    struct HuffmanNode* h;
    for(int i=0;i<n;i++){
        cin>> s;
        cin>> freq;
        h = new HuffmanNode();
        h->s=s;
        h->freq=freq;
        PQ.push(h);
    }
    //print_pq();
    return n;
}

struct HuffmanNode* build_tree(){
    struct HuffmanNode *x,*y,*z;
    while (PQ.empty() != true) {
        x = PQ.top();
        PQ.pop();
        if (PQ.empty() == true) {
            return x;
        }
        y = PQ.top();
        PQ.pop();

        z = new HuffmanNode();
        z->freq = x->freq + y->freq;
        z->s = "";
        z->left = x;
        z->right = y;
        PQ.push(z);

        x->bit = false;
        y->bit = true;
    }
}


void extract_encoding(struct HuffmanNode *root, string current_string, map<char, string> &M){
    if (root->left != NULL) {
        extract_encoding(root->left, current_string+"0", M);
    }
    if (root->right != NULL) {
        extract_encoding(root->right, current_string+"1", M);
    }
    if(root->left == NULL && root->right == NULL) {
        M[root->s[0]] = current_string;
    }
    return;
}

void print_encoding(map<char, string> M){
    for(auto it=M.begin(); it != M.end(); it++){
        cout<< it->first<< " " << it->second<<endl;
    }
}

string encode_huffman(string s, map<char,string>M) {
    string encode = "";
    for(int i=0;i<s.size(); i++){
        encode = encode + M[s[i]];
    }
    return encode;
}

string decode_huffman(string s, HuffmanNode *root){
    int i=0;
    string decoded = "";
    HuffmanNode *current;
    while (i<s.size()) {
        current = root;
        while (!(current->left == NULL && current->right == NULL)) {
            if (s[i] == '0') {
                current = current->left;
            }
            else {
                current = current->right;
            }
            i=i+1;
        }
        decoded = decoded + current->s;
    }
    return decoded;
}

int main(void) {
    freopen("in.txt", "r", stdin);
    int n = input();
    struct HuffmanNode* root = build_tree();
    cout<< root << endl;
    map<char, string> M;
    extract_encoding(root, "", M);
    print_encoding(M);
    string encoded_string = encode_huffman("abcaa", M);
    cout<<encoded_string<<endl;
    string dec_input;
    //cin>>dec_input;
    string decoded_string = decode_huffman(encoded_string, root);
    cout<<decoded_string<<endl;
    return 0;
}
