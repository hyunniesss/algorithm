#include <iostream>

using namespace std;

int main()
{
    int a;
    cin >> a;
    if (a >= 20)
    {
        cout << "adult";
    }
    else
    {
        cout << (20 - a) << " years later";
    }
}