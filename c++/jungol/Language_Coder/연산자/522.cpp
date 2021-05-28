#include <iostream>

using namespace std;

int main()
{
    int a[2];
    cin >> a[0] >> a[1];
    if (a[0] == a[1])
    {
        cout << 1 << endl;
        cout << 0;
    }
    else
    {
        cout << 0 << endl;
        cout << 1;
    }
}