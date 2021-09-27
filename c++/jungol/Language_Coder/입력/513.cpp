#include <iostream>
#define INCH 2.54
#define YARD 91.44

using namespace std;

int main(){
    float a = 2.1;
    printf("%4.1fyd = %5.1fcm\n", a, a*YARD);
    a = 10.5;
    printf("%4.1fin = %5.1fcm", a, a*INCH);
}