public class Mahasiswa03 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa03() {
    }

    public Mahasiswa03(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

public void tampilInformasi() {
    System.out.printf("%s\t%s\t%s\t%.1f\n", nama, nim, kelas, ipk);
}
}