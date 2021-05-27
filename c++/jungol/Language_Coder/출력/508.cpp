#include <iostream>
#define MAX 3

using namespace std;

string tab = "          ";

string abc(int len){
    return tab.substr(0, tab.length() - len);
}

int main(){
    string section[3]{"item", "count", "price"};

    string items[3]{"pen", "note", "eraser"};
    int counts[3] {20, 5, 110};
    int prices[3] {100, 95, 97};
    for(int i=0 ; i < MAX ; i++){
        cout << abc(section[i].length()) << section[i];
    }
    cout << endl;
    for(int i=0;i<MAX;i++){
        cout << abc(items[i].length()) << items[i];
        cout << abc(to_string(counts[i]).length()) << counts[i];
        cout << abc(to_string(prices[i]).length()) << prices[i] << endl;
    }
    
    return 0;

}

