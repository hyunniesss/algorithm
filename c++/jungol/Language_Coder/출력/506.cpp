#include <iostream>

using namespace std;

int main()
{
    string str1 = "My height";
    int height = 170;
    string str2 = "My weight";
    double weight = 68.6000000;

    cout << str1 << endl;
    cout << height << endl;
    cout << str2 << endl;
    cout<<fixed;
    cout.precision(6);
    cout << weight;

    return 0;
}
