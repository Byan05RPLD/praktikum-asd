    class AntrianKRS {
        MahasiswaKRS[] data;
        int front, rear, size, max, jumlahDiproses;

        public AntrianKRS(int max) {
            this.max = max;
            data = new MahasiswaKRS[max];
            front = rear = -1;
            size = 0;
            jumlahDiproses = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean isFull() {
            return size == max;
        }
        public void enqueue(MahasiswaKRS m) {
            if (isFull()) {
                System.out.println("Queue penuh! Program dihentikan.");
                System.exit(1);
        }
        if (isEmpty()) {
            front = rear = 0;
            } else {
                rear++;
            }
            data[rear] = m;
            size++;
        }
        public void prosesKRS() {
            if (size < 2) {
                System.out.println("Minimal 2 mahasiswa diperlukan untuk proses KRS.");
                System.exit(1);
            }
            System.out.println("Memproses 2 mahasiswa:");
            for (int i = 0; i < 2; i++) {
                MahasiswaKRS m = data[front];
                m.tampilkanData();
                for (int j = front; j < rear; j++) {
                    data[j] = data[j + 1];
                }
                rear--;
                size--;
                jumlahDiproses++;
            }
            if (size == 0) front = rear = -1;
        }
        public void tampilkanSemua() {
            if (isEmpty()) {
                System.out.println("Antrian kosong.");
            } else {
                System.out.println("Semua mahasiswa dalam antrian:");
                for (int i = front; i <= rear; i++) {
                    data[i].tampilkanData();
                }
            }
        }
        public void tampilkanTerdepan() {
            if (size >= 1) data[front].tampilkanData(); 
            if (size >= 2) data[front + 1].tampilkanData(); 
        }
        public void tampilkanBelakang() {
            if (!isEmpty()) {
                data[rear].tampilkanData();
            } else {
                System.out.println("Antrian kosong");
            }
        }
        public int getJumlahAntrian() {
            return size;
        }
        public int getJumlahDiproses() {
            return size;
        }
        public int getSisaMahasiswa() {
            return 30 - jumlahDiproses;
        }
        public void clear() {
            front = rear = -1;
            size = 0;
        }
 }
        


          
        