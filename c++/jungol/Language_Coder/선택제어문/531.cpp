#include <iostream>

using namespace std;

int main()
{
    double a;
    cin >> a;
    string b;
    if (a <= 50.80)
    {
        b = "Flyweight";
    }
    else if (a <= 61.23)
    {
        b = "Lightweight";
    }
    else if (a <= 72.57)
    {
        b = "Middleweight";
    }
    else if (a <= 88.45)
    {
        b = "Cruiserweight";
    }
    else
    {
        b = "Heavyweight";
    }
    cout << b;
}