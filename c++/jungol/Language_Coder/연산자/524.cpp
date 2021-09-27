#include <iostream>

using namespace std;

int main()
{
    int a, b;
    cin >> a >> b;
    bool c = a & b;
    bool d = a | b;
    cout << c << " " << d;
}