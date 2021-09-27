#include <iostream>

using namespace std;

int main()
{
    char gen;
    int age;
    cin >> gen >> age;
    string answer;
    if (age >= 18)
    {
        if (gen == 'M')
        {
            answer = "MAN";
        }
        else
        {
            answer = "WOMAN";
        }
    }
    else
    {
        if (gen == 'M')
        {
            answer = "BOY";
        }
        else
        {
            answer = "GIRL";
        }
    }

    cout << answer;
}