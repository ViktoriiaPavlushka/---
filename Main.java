//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.insert(6, 2);
        list.insert(7, 0);
        list.insert(8, 7);
        list.insert(9, 9);
        list.setNodeAtIndex(0, 10);
        list.setNodeAtIndex(2, 20);
        list.setNodeAtIndex(4, 30);
        list.setNodeAtIndex(6, 40);
        list.setNodeAtIndex(8, 50);
        list.setNodeAtIndex(10, 60);
        System.out.println("Size of the linked list: " + list.size());
        list.print();
    }
}*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Insert");
            System.out.println("3. Set");
            System.out.println("4. Print");
            System.out.println("5. Size");
            System.out.println("6. Erase");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int valueToAdd = scanner.nextInt();
                    list.add(valueToAdd);
                    break;
                case 2:
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    System.out.print("Enter index to insert at: ");
                    int indexToInsert = scanner.nextInt();
                    list.insert(valueToInsert, indexToInsert);
                    break;
                case 3:
                    System.out.print("Enter index to set value: ");
                    int indexToSet = scanner.nextInt();
                    System.out.print("Enter value to set: ");
                    int valueToSet = scanner.nextInt();
                    list.setNodeAtIndex(indexToSet, valueToSet);
                    break;
                case 4:
                    System.out.println("Linked List:");
                    list.print();
                    break;
                case 5:
                    System.out.println("Size of the linked list: " + list.size());
                    break;
                case 6:
                    System.out.print("Enter index of beginning to erase: ");
                    int indexToStartErase = scanner.nextInt();
                    System.out.print("Enter amount of elements to erase: ");
                    int amount = scanner.nextInt();
                    list.erase(indexToStartErase, amount);
                    break;
                case 7:
                    System.out.println("goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
