#include <iostream>

using namespace std;

int main(){
    int sum = 0;
    int a;
    for(int i=0;i<3;i++){
        cin>>a;
        sum+=a;
    }
    cout<<"sum = "<<sum<<endl;
    cout<<"avg = "<<sum/3;
}