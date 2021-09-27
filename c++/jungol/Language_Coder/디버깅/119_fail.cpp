#include <iostream>
#include <ctime>

using namespace std;

int main()
{
    int a = 0;
    time_t now;
    struct tm tt;
    time(&now);
    tt = *localtime(&now);
    a = tt.tm_year;
    cout << a << " ";
    a += tt.tm_mon;
    cout << a << " ";
    a += tt.tm_mday;
    cout << a << endl;
}