#include <iostream>

using namespace std;

int main()
{
    int sum = 0;

    for (int i = 0; i < 3; i++)
    {
        int temp;
        cin >> temp;
        sum += temp;
    }
    cout << "sum : " << sum << endl;
    cout << "avg : " << sum / 3;
}