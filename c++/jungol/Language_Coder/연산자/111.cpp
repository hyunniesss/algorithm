#include <iostream>

using namespace std;

int main()
{
    int arr[4];
    int sum = 0;
    for (int a : arr)
    {
        cin >> a;
        sum += a;
    }
    cout << "sum " << sum << endl;
    cout << "avg " << sum / 4;
}