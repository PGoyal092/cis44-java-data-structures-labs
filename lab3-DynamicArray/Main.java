public static void main(String[] args) {
    DynamicArray<Integer> arr = new DynamicArray<>();
    arr.add(10);
    arr.add(20);
    arr.add(30);

    System.out.println("Array: " + arr);   // [10, 20, 30]
    System.out.println("Get index 1: " + arr.get(1)); // 20

    System.out.println("Removed: " + arr.remove(1));  // Removes 20
    System.out.println("Array after removal: " + arr); // [10, 30]

    System.out.println("Size: " + arr.size()); // 2
}

