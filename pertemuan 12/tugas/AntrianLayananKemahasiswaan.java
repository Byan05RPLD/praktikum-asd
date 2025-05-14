package tugas;
import java.util.Scanner;
public class AntrianLayananKemahasiswaan {
    public static void main(String[ ] args) {
        Scanner input = new Scanner(System.in);
        AntrianMahasiswa antrian = new AntrianMahasiswa();
        int pilihan;
        do {
            System.out.println("\n --- MENU ANTRIAN LAYANAN KEMAHASISWAAN --- ");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Lihat Antrian Depan dan Belakang");
            System.out.println("4. Cek Antrian Kosong");
            System.out.println("5. Kosongkan Antrian");
            System.out.println("6. Tampilkan Jumlah Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
                case 1:
                System.out.print("Masukkan Nama mahasiswa: ");
                String nama = input.nextLine();System.out.print("Masukkan NIM mahasiswa : ");
                String nim = input.nextLine();
                antrian.enqueue(nama, nim);
                break;
                case 2:
                antrian.dequeue();
                break;
                case 3:
                antrian.tampilkanDepanBelakang();
                break;
                case 4:
                if (antrian.isEmpty()) {
                    System.out.println("Antrian kosong.");
                } else {
                    System.out.println("Antrian tidak kosong.");
                }
                    break;
                    case 5:
                    antrian.kosongkanAntrian();
                    break;
                    case 6:
                    antrian.tampilkanJumlah();
                    break;
                    case 0:
                    System.out.println("Program selesai.");
                    break;
                    default:
                    System.out.println("Pilihan tidak valid.");
            }
            }    while (pilihan != 0);

            input.close();
        }
    }
