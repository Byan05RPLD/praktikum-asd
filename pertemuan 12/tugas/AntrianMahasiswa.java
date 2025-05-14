package tugas;

class AntrianMahasiswa {
    private Mahasiswa front, rear;
    private int size;

    public AntrianMahasiswa() {
    front = rear = null;
    size = 0;
}
    
    public boolean isEmpty() {
        return front == null;
    }
    public void enqueue(String nama, String nim) {
        Mahasiswa baru = new Mahasiswa(nama, nim);
        if (isEmpty()) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
            size++;
            System.out.println("Mahasiswa " + nama + " berhasil ditambahkan ke antrian.");
    }

            public void dequeue() {
                if (isEmpty()) {
                    System.out.println("Antrian kosong, tidak ada mahasiswa yang dipanggil.");
                
                } else {
                    System.out.println("Mahasiswa " + front.nama + " dengan NIM " + front.nim + " dipanggil.");
                    front = front.next;
                    size--;
                    if (front == null) {
                        rear = null;
                    }
                }
            }
                    public void tampilkanDepanBelakang() {
                        if (isEmpty()) {
                            System.out.println("Antrian kosong.");
                        } else {
                            System.out.println("Mahasiswa di depan: " + front.nama + " (" + front.nim + ")");
                            System.out.println("Mahasiswa di belakang: " + rear.nama + " (" + rear.nim + ")");
                        }
                    }

                    public void kosongkanAntrian() {
                        front = rear = null;
                        size = 0;
                        System.out.println("Antrian telah dikosongkan.");
                    }
                    public void tampilkanJumlah() {
                        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
                    }
                }

