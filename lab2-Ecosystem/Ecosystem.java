import java.util.Random;
import java.util.Scanner;

// Step 1: Abstract parent class
abstract class Animal {
    public abstract String toString();
    public abstract Animal cloneAnimal(); // for making "babies"
}

// Step 2: Concrete classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public Animal cloneAnimal() {
        return new Bear();
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }

    @Override
    public Animal cloneAnimal() {
        return new Fish();
    }
}

// Main class
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        // Initial population: randomly add Bears, Fish, or leave empty
        for (int i = 0; i < river.length; i++) {
            int choice = random.nextInt(3); // 0 = empty, 1 = Bear, 2 = Fish
            if (choice == 1) river[i] = new Bear();
            else if (choice == 2) river[i] = new Fish();
        }
    }

    public void runStep() {
        Animal[] newRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            if (river[i] == null) continue;

            Animal current = river[i];
            int move = random.nextInt(3) - 1; // -1, 0, or +1
            int newPos = i + move;

            if (newPos < 0 || newPos >= river.length) {
                newPos = i; // stay if out of bounds
            }

            if (newRiver[newPos] == null) {
                // empty slot, move succeeds
                newRiver[newPos] = current;
            } else {
                // collision
                if (newRiver[newPos].getClass() == current.getClass()) {
                    // Same species -> spawn baby somewhere random
                    spawnAnimal(newRiver, current.cloneAnimal());
                    // keep one in place, discard the other (so nothing extra happens)
                    newRiver[newPos] = current;
                } else {
                    // Bear eats Fish
                    if (current instanceof Bear && newRiver[newPos] instanceof Fish) {
                        newRiver[newPos] = current; // bear replaces fish
                    } else if (current instanceof Fish && newRiver[newPos] instanceof Bear) {
                        // fish disappears, bear stays (do nothing)
                    }
                }
            }
        }

        river = newRiver;
    }

    private void spawnAnimal(Animal[] arr, Animal baby) {
        // collect empty spots
        int[] empty = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) empty[count++] = i;
        }
        if (count > 0) {
            int pos = empty[random.nextInt(count)];
            arr[pos] = baby;
        }
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // River of size 20
        eco.visualize();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of steps: ");
        int userCount = input.nextInt();

        for (int step = 1; step <= userCount; step++) {
            eco.runStep();
            System.out.print("Step " + step + ": ");
            eco.visualize();
        }
    }
}