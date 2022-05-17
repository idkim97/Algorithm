using namespace std;

int gcd_f(int a, int b) {
    int c;
    while (b != 0) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

long long solution(int w, int h) {
    long long answer = 1;

    long long gcd = gcd_f(w, h);

    long long del = ((long long)w + (long long)h - gcd);
    answer = (long long)w * (long long)h - del;

    return answer;
}