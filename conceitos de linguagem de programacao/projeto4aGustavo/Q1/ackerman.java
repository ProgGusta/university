public class ackerman 
{

    public static int acker(int m, int n) 
    {
        if (m == 0) 
            return n + 1;
        else if (m > 0 && n == 0) 
            return acker(m - 1, 1);
        else if (m > 0 && n > 0) 
            return acker(m - 1, acker(m, n - 1));

        return 0; // Isso nunca deve ser alcançado
    }

    public static void main(String[] args) 
    {
        int m = 2, n = 3;
        System.out.println("Ackerman(" + m + ", " + n + ") = " + acker(m, n));
    }
}
