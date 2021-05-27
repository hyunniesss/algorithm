#include <iostream>
#define SIZE 5
#define SPACE " "

using namespace std;

int main()
{

    string a[SIZE]{"Seoul", "Pusan", "Incheon", "Daegu", "Gwangju"};
    string b[SIZE]{"10,312,545", "3,567,910", "2,758,296", "2,511,676", "1,454,636"};
    string c[SIZE]{"+91,375", "+5,868", "+64,888", "+17,230", "+29,774"};

    for(int i=0;i<SIZE;i++){
        while(a[i].length() < 15){
            a[i] = SPACE + a[i];
        }
        while(b[i].length() < 15) {
            b[i] = SPACE + b[i];
        }
        while(c[i].length() < 15) {
            c[i] = SPACE + c[i];
        }
        cout << a[i] << b[i] << c[i] <<endl;
    }

    return 0;
}