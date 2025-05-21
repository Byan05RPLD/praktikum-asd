package dll;

import java.util.Scanner;

public class DLLMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoubleLinkedLists list = new DoubleLinkedLists();
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah data setelah NIM tertentu");
            System.out.println("8. Tambah data di indeks tertentu");
            System.out.println("9. Hapus data setelah NIM tertentu");
            System.out.println("10. Hapus data berdasarkan indeks");
            System.out.println("11. Tampilkan data pertama/terakhir/berdasarkan indeks");
            System.out.println("12. Tampilkan jumlah data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa01 mhs = inputMahasiswa01(scan);
                    list.addFirst(mhs);
                }
                case 2 -> {
                    Mahasiswa01 mhs = inputMahasiswa01(scan);
                    list.addLast(mhs);
                }
                case 3 -> list.removeFirst();
                case 4 -> list.removeLast();
                case 5 -> list.print();
                case 6 -> {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node01 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan: ");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                }
                case 7 -> {
                    System.out.print("Masukkan NIM yang akan disisipi datanya: ");
                    String keyNim = scan.nextLine();
                    Mahasiswa01 mhsBaru = inputMahasiswa01(scan);
                    list.insertAfter(keyNim, mhsBaru);
                }
                case 8 -> {
                    System.out.print("Masukkan indeks: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa01 m = inputMahasiswa01(scan);
                    list.add(m, idx);
                }
                case 9 -> {
                    System.out.print("Masukkan NIM: ");
                    String nim = scan.nextLine();
                    list.removeAfter(nim);
                }
                case 10 -> {
                    System.out.print("Masukkan indeks: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    list.remove(idx);
                }
                case 11 -> {
                    System.out.print("Masukkan indeks: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa01 first = list.getFirst();
                    Mahasiswa01 last = list.getLast();
                    Mahasiswa01 byIndex = list.getIndex(idx);
                    System.out.println("Data pertama:");
                    if (first != null) first.tampil();
                    System.out.println("Data terakhir:");
                    if (last != null) last.tampil();
                    System.out.println("Data indeks ke-" + idx + ":");
                    if (byIndex != null) byIndex.tampil();
                }
                case 12 -> {
                    System.out.println("Jumlah data dalam linked list: " + list.getSize());
                }
                case 0 -> System.out.println("keluar dari program.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        scan.close();
    }

    public static Mahasiswa01 inputMahasiswa01(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();

        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();

        double ipk = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Masukkan IPK : ");
                ipk = scan.nextDouble();
                scan.nextLine();
                valid = true;
            } catch (Exception e) {
                System.out.println("Input IPK tidak valid. Coba lagi.");
                scan.nextLine();
            }
        }

        return new Mahasiswa01(nim, nama, kelas, ipk);
    }
}
