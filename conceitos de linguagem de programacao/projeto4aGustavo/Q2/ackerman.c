#include <stdio.h>
#include <time.h>

int ackerman(int m, int n) {
    if (m == 0) {
        return n + 1;
    } else if (m > 0 && n == 0) {
        return ackerman(m - 1, 1);
    } else {
        return ackerman(m - 1, ackerman(m, n - 1));
    }
}

int main() {
    int m_values[] = {0, 1, 2, 3};
    int n_values[] = {0, 1, 2, 3};
    int m, n;
    double time_spent;
    FILE *fp;
    fp = fopen("c_ackerman_times.csv", "w");
    fprintf(fp, "m,n,time\n");

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            m = m_values[i];
            n = n_values[j];
            clock_t begin = clock();
            ackerman(m, n);
            clock_t end = clock();
            time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
            fprintf(fp, "%d,%d,%f\n", m, n, time_spent);
        }
    }
    fclose(fp);
    return 0;
}
