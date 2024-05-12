import java.util.Scanner;

public class RecursiveProduct {
    
    public static int multiplyRecursive(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        } else {
            return numbers[index] * multiplyRecursive(numbers, index + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        int product = multiplyRecursive(numbers, 0);
        System.out.println("Product of the numbers: " + product);
        
        scanner.close();
    }
}