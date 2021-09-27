#include <iostream>
#define t "T"
#define enter "\n"
#define space " "

using namespace std;

int main(){
    string answer = "";
    for(int i=0;i<2;i++){
        for(int j=0;j<10;j++){
            answer+=t;
        }
        answer+=enter;
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            answer+=space;
        }
        for(int j=0;j<2;j++){
            answer+=t;
        }
        answer+=enter;
    }
    cout<<answer;
    
    return 0;
}