#include <iostream>

using namespace std;

int main()
{
    int w, h;
    cin >> h >> w;
    int ob = w + 100 - h;
    cout << ob << endl;
    if (ob > 0)
    {
        cout << "Obesity";
    }
}