#include <iostream>

using namespace std;

int main()
{
    double a, b;
    cin >> a >> b;
    string c;
    if (a >= 4.0 && b >= 4.0)
    {
        c = "A";
    }
    else if (a >= 3.0 && b >= 3.0)
    {
        c = "B";
    }
    else
    {
        c = "C";
    }
    cout << c;
}