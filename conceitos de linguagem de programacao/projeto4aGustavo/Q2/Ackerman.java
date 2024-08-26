import java.io.FileWriter;
import java.io.IOException;

public class Ackerman {
    public static int ackerman(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackerman(m - 1, 1);
        } else {
            return ackerman(m - 1, ackerman(m, n - 1));
        }
    }

    public static void main(String[] args) {
        int[] m_values = {0, 1, 2, 3};
        int[] n_values = {0, 1, 2, 3};

        try (FileWriter writer = new FileWriter("java_ackerman_times.csv")) {
            writer.append("m,n,time\n");
            for (int m : m_values) {
                for (int n : n_values) {
                    long start = System.nanoTime();
                    ackerman(m, n);
                    long end = System.nanoTime();
                    double time = (end - start) / 1e9;
                    writer.append(m + "," + n + "," + time + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
