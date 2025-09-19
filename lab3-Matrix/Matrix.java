import java.util.Random;
public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException();
        }
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != data[0].length) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(data[i], 0, this.data[i], 0, data[i].length);
        }
    }
    public void populateRandom(){
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = random.nextInt(10)+1;
            }
        }
    }
    public Matrix add(Matrix other){
        if (other == null) {
            throw new IllegalArgumentException();
        }
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }
    public Matrix multiply(Matrix other){
        if (this.data[0].length != other.data.length) {
            throw new IllegalArgumentException();
        }
        int  rows = this.data.length;
        int cols = other.data[0].length;
        int common = this.data[0].length;
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(String.format("%4d", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}