#include <iostream>

using namespace std;

int main()
{
    char a;
    cin >> a;
    string answer;
    switch (a)
    {
    case 'A':
        answer = "Excellent";
        break;
    case 'B':
        answer = "Good";
        break;
    case 'C':
        answer = "Usually";
        break;
    case 'D':
        answer = "Effort";
        break;
    case 'F':
        answer = "Failure";
        break;
    default:
        answer = "error";
    }
    cout << answer;
}