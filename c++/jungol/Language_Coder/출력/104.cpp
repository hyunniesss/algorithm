#include <iostream>
#define space " "
#define enter "\n"

using namespace std;

int score[3] {90, 80, 100};

int sumF(){
    int answer =0;
    for(int i=0;i<3;i++){
        answer+=score[i];
    }
    return answer;
}

int avg(int sum){
    return sum/3;
}

int main(){
    
    string name[5] {"kor", "mat", "eng", "sum", "avg"};

    string answer = "";
    for(int i=0;i<3;i++){
        answer+=name[i];
        answer+=space;
        answer+=(to_string(score[i]));
        answer+=enter;
    }   

    answer+=name[3];
    answer+=space;
    int sum = sumF();
    answer+=(to_string(sum));
    answer+=enter;

    answer+=name[4];
    answer+=space;
    answer+=(to_string(avg(sum)));
    
    cout<<answer;

    return 0;
}