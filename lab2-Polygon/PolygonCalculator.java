import java.util.Scanner;

import static java.lang.Math.sqrt;

interface Polygon{
    double area();
    double perimeter();
}

class Pentagon implements Polygon {
    protected double side;
    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }

    @Override
    public double area() {
        return (0.25 * sqrt(5 * (5 + 2 * sqrt(5))) * side * side);
    }
}

class Hexagon implements Polygon {
    protected double side;
    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }

    @Override
    public double area() {
        return (3 * sqrt(3) / 2) * side * side;
    }
}

class Octagon implements Polygon {
    protected double side;
    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }
    @Override
    public double area() {
        return 2 * (1 + sqrt(2)) * side * side;
    }
}

class Triangle implements Polygon{
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    @Override
    public double perimeter(){
        return 0;
    }
    @Override
    public double area(){
        return 0;
    }
}

class IsoscelesTriangle extends Triangle{
    protected double a;
    protected double b;
    protected double c;

    public IsoscelesTriangle(double a, double b, double c){
        super(a,b,c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter(){
        return a+b+c;
    }

    @Override
    public double area(){
        return (0.5*b*sqrt((a*a)-((b*b)/4)));
    }
}

class EquilateralTriangle extends Triangle{
    protected double side;

    public EquilateralTriangle(double side){
        super(side,side,side);
        this.side=side;
    }

    @Override
    public double perimeter(){
        return 3*side;
    }

    @Override
    public double area(){
        return ((sqrt(3)/4)*(side*side));
    }
}

class Quadrilateral implements Polygon{
    // What attributes do all quadrilaterals have?
    protected double side1;
    protected double side2;
    protected double side3;
    protected double side4;

    @Override
    public double area(){
        // To be implemented by subclasses
        return 0;
    }
    @Override
    public double perimeter(){
        // To be implemented by subclasses
        return 0;
    }
}

class Rectangle extends Quadrilateral{
    protected double length;
    protected double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double area(){
        return length*width;
    }
    @Override
    public double perimeter(){
        return (2*length)+(2*width);
    }
}

class Square extends Rectangle{
    public Square(double side){
        //How do you call the Rectangle constructor from here?
        super(side,side);
    }
}

//Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polygon shape = null;
        char go ='Y';
        while(go=='Y') {
            System.out.println("Choose a polygon #:");
            System.out.println("1. Equilateral Triangle");
            System.out.println("2. Isosceles Triangle");
            System.out.println("3. Rectangle");
            System.out.println("4. Square");
            System.out.println("5. Pentagon (regular)");
            System.out.println("6. Hexagon (regular)");
            System.out.println("7. Octagon (regular)");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter side: ");
                    shape = new EquilateralTriangle(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter equal sides and base: ");
                    shape = new IsoscelesTriangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter length and width: ");
                    shape = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter side: ");
                    shape = new Square(scanner.nextDouble());
                    break;
                case 5:
                    System.out.print("Enter side: ");
                    shape = new Pentagon(scanner.nextDouble());
                    break;
                case 6:
                    System.out.print("Enter side: ");
                    shape = new Hexagon(scanner.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter side: ");
                    shape = new Octagon(scanner.nextDouble());
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.exit(0);
            }

            System.out.println("Perimeter: " + shape.perimeter());
            System.out.println("Area: " + shape.area());
            System.out.println("Again? (Y/N): ");
            go = scanner.next().charAt(0);
        }
    }
}