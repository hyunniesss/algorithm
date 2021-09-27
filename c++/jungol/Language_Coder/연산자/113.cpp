#include <iostream>

using namespace std;

int main()
{
    int a, b;
    cin >> a >> b;
    a += 5;
    b *= 2;

    cout << "width = " << a << endl;
    cout << "length = " << b << endl;
    cout << "area = " << a * b;
}