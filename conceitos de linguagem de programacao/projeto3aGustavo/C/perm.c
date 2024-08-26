#include <stdio.h>
#include <time.h>

void perm(int arr[], int i, int j)
{
	int aux = arr[i];
	arr[i] = arr[j];
	arr[j] = aux;
}

void permuta(int arr[], int inf, int sup)
{
	if(inf != sup)
    {
		for(int i = inf; i <= sup; i++)
        {
			perm(arr, inf, i);
			permuta(arr, inf + 1, sup);
			perm(arr, inf, i);
		}
	}
}

int main()
{
    int  n = 0;
    int v[50];
    clock_t start, end;
    double time = 0.0;
    while(time < 70.00)
    {
        v[n] = n;
        n++; 
        start = clock();
        permuta(v, 0, n- 1);
        end = clock();
        time = ((double)(end - start)) / CLOCKS_PER_SEC;
        printf("n = %d, time = %lf\n", n, time);
    }
	

	return 0;
}