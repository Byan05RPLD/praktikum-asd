import java.util.Scanner;

public class QueueMain {

    public static void menu() {
        System.out.println("\nMasukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("------------------------------");
        System.out.print("Menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int n = sc.nextInt();
        Queue Q = new Queue(n);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1 -> {
                    System.out.print("Masukkan data baru: ");
                    int data = sc.nextInt();
                    Q.enqueue(data);
                }
                case 2 -> {
                    int data = Q.dequeue();
                    if (data != -1) {
                        System.out.println("Data yang dikeluarkan: " + data);
                    }
                }
                case 3 -> Q.print();
                case 4 -> Q.peek();
                case 5 -> Q.clear();
                default -> {
                    if (pilih != 0) {
                        System.out.println("Pilihan tidak valid!");
                    }
                }
            }
        } while (pilih != 0);
    }
}
