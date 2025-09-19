public class Main {
    public static void main(String[] args) {
        // Create two random 2x3 matrices
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(2, 3);
        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix m1:");
        System.out.println(m1);

        System.out.println("Matrix m2:");
        System.out.println(m2);

        // Matrix addition
        try {
            Matrix sum = m1.add(m2);
            System.out.println("m1 + m2:");
            System.out.println(sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Addition Error");
        }

        // Matrix multiplication
        Matrix m3 = new Matrix(3, 2);
        m3.populateRandom();

        System.out.println("Matrix m3:");
        System.out.println(m3);

        try {
            Matrix product = m1.multiply(m3);
            System.out.println("m1 x m3:");
            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Multiplication Error");
        }
    }
}