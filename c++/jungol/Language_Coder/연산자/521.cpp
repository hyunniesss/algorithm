#include <iostream>

using namespace std;

int main()
{
    int a[2];

    for (int i = 0; i < 2; i++)
    {
        cin >> a[i];
    }

    int c = a[0]++ * --a[1];

    cout << a[0] << " " << a[1] << " " << c;
}