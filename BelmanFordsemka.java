import java.util.ArrayList;
public class BelmanFordsemka {
    public static void BellmanFord(double[][] matrix, int start) {
        int verticesCount = matrix.length;
        int INF = 999999999;
        double[] lambdas = new double[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            lambdas[i] = INF;
        }

        lambdas[start - 1] = 0.0;

        for (int k = 1; k <= verticesCount - 1; k++) {
            double[] newLambdas = lambdas.clone();

            for (int from = 0; from < verticesCount; from++) {
                for (int to = 0; to < verticesCount; to++) {
                    if (matrix[from][to] != INF && lambdas[from] != INF) {
                        if (newLambdas[to] > lambdas[from] + matrix[from][to]) {
                            newLambdas[to] = lambdas[from] + matrix[from][to];
                        }
                    }
                }
            }

            lambdas = newLambdas;
        }
    }
}
