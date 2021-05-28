#include <iostream>

using namespace std;

int main()
{
    int a, b;
    cin >> a >> b;
    bool flag = a > b;
    cout << a << " > " << b << " --- " << flag << endl;
    flag = a < b;
    cout << a << " < " << b << " --- " << flag << endl;
    flag = a >= b;
    cout << a << " >= " << b << " --- " << flag << endl;
    flag = a <= b;
    cout << a << " <= " << b << " --- " << flag << endl;
}