package dll;

public class DoubleLinkedLists {
    Node01 head;
    Node01 tail;
    int size = 0;

    public DoubleLinkedLists() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(Mahasiswa01 data) {
        Node01 newNode = new Node01(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa01 data) {
        Node01 newNode = new Node01(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(Mahasiswa01 data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node01 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node01 newNode = new Node01(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa01 data) {
        Node01 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        Node01 newNode = new Node01(data);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak ada yang dihapus.");
        } else {
            System.out.print("Data yang terhapus: ");
            head.data.tampil();
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            System.out.println("Data sudah berhasil dihapus.");
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak ada yang dihapus.");
        } else {
            System.out.print("Data yang terhapus: ");
            tail.data.tampil();
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            System.out.println("Data sudah berhasil dihapus.");
        }
    }

    public void removeAfter(String keyNim) {
        Node01 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Tidak ada node setelah NIM tersebut atau NIM tidak ditemukan.");
            return;
        }
        Node01 toDelete = current.next;
        System.out.print("Data yang terhapus: ");
        toDelete.data.tampil();

        if (toDelete == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }
        size--;
        System.out.println("Data sudah berhasil dihapus.");
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node01 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.print("Data yang terhapus: ");
            current.data.tampil();
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            System.out.println("Data sudah berhasil dihapus.");
        }
    }

    public Mahasiswa01 getFirst() {
        return isEmpty() ? null : head.data;
    }

    public Mahasiswa01 getLast() {
        return isEmpty() ? null : tail.data;
    }

    public Mahasiswa01 getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return null;
        }
        Node01 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong. Tidak ada data yang ditampilkan.");
            return;
        }

        Node01 current = head;
        int i = 1;
        while (current != null) {
            System.out.print(i + ". ");
            if (current.data != null) {
                current.data.tampil();
            } else {
                System.out.println("(Data kosong/null)");
            }
            current = current.next;
            i++;
        }
    }

    public Node01 search(String nim) {
        Node01 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
