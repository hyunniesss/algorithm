#include <iostream>

using namespace std;

int main()
{
    int a[2];

    for (int i = 0; i < 2; i++)
    {
        cin >> a[i];
    }

    cout << a[0] + 100 << " " << a[1] % 10;
}