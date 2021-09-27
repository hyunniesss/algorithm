#include <iostream>
#define YARD 91.44

using namespace std;

int main()
{
    // 입력 = 야드 , 환산 = 센티미터
    // 소수 둘 째자리
    cout << "yard? ";
    double yard;
    cin >> yard;
    printf("%.1fyard = %.2fcm", yard, yard*YARD);
}