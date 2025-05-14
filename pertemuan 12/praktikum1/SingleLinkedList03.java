public class SingleLinkedList03 {
    NodeMahasiswa03 head;
    NodeMahasiswa03 tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa03 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println();
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void addFirst(Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        NodeMahasiswa03 temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, Mahasiswa03 input) {
        if (index < 0) {
            System.out.println("Indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa03 temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                temp.next = new NodeMahasiswa03(input, temp.next);
                if (temp.next.next == null) {
                    tail = temp.next;
                }
            } else {
                System.out.println("Indeks melebihi ukuran list");
            }
        }
    }
    public void getData(int index) {
        NodeMahasiswa03 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
            tmp.data.tampilInformasi();
        }
    }
        
    public int indexOf(String key) {
        NodeMahasiswa03 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }
    public void removeLast(){
        if (isEmpty()){
            System.out.println("Linked List Masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa03 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
                temp.next = null;
                tail = temp;
        }
    }
    public void remove (String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus!");
        } else {
            NodeMahasiswa03 temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.data.nama.equalsIgnoreCase(key)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                        break;
                }
                        temp = temp.next;
                    }
                }
            }
        
                public void removeAt(int index) {
                    if (index == 0) {
                        removeFirst();
                    } else {
                            NodeMahasiswa03 temp = head;
                            for (int i = 0; i < index - 1; i++) {
                                temp = temp.next;
                            }
                                temp.next = temp.next.next;
                                if (temp.next == null) {
                                    tail = temp;
                                }
                            }
                        }
                    }
