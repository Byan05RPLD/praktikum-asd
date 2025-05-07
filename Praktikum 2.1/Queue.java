public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(int dt) {
        if (isFull()) {
            System.out.println("Queue overflow! Program dihentikan.");
            System.exit(1); // Hentikan program saat overflow
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }
        data[rear] = dt;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Program dihentikan.");
            System.exit(1); // Hentikan program saat underflow
        }
        int temp = data[front];
        size--;
        if (isEmpty()) {
            front = rear = -1;
        } else {
            front = (front + 1) % max;
        }
        return temp;
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue kosong!");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return;
        }
        System.out.print("Isi Queue: ");
        int i = front;
        while (true) {
            System.out.print(data[i] + " ");
            if (i == rear) break;
            i = (i + 1) % max;
        }
        System.out.println();
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Queue berhasil dikosongkan");
    }
}
