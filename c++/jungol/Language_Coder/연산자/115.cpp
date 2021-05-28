#include <iostream>

using namespace std;

int main()
{
    int mw, mh, gw, gh;
    cin >> mw >> mh >> gw >> gh;

    if (mw > gw && mh > gh)
    {
        cout << 1;
    }
    else
    {
        cout << 0;
    }
}