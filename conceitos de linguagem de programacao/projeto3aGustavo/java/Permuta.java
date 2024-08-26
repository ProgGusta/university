public class Permuta 
{
    
    public static void perm(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void permuta(int[] arr, int start, int end) 
    {
        if (start != end) 
        {
            for (int i = start; i <= end; i++) 
            {
                perm(arr, start, i);
                permuta(arr, start + 1, end);
                perm(arr, start, i);
            }
        }
    }
    
    public static void main(String[] args) 
    {
        int n = 0;
        int[] v = new int[50];
        long start, end;
        double tempo = 0.0;

        while (tempo < 70.0) 
        {
            v[n] = n;
            n++;
            start = System.currentTimeMillis();
            permuta(v, 0, n - 1);
            end = System.currentTimeMillis();
            tempo = (end - start) / 1000.0;
            System.out.println("n = " + n + ", tempo = " + tempo);
        }
    }
}