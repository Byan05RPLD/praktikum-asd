package pertemuan14;

public class BinaryTree03 {
    Node03 root;

    public BinaryTree03() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        tampilMahasiswaIPKdiAtasHelper(root, ipkBatas);
    }

    public void tampilMahasiswaIPKdiAtasHelper(Node03 node, double ipkBatas) {
        if (node == null)
            return;

        tampilMahasiswaIPKdiAtasHelper(node.left, ipkBatas);

        if (node.mahasiswa.ipk > ipkBatas) {
            node.mahasiswa.tampilInformasi();
        }

        tampilMahasiswaIPKdiAtasHelper(node.right, ipkBatas);
    }

    public Mahasiswa03 cariMinIPK() {
        if (root == null) {
            return null;
        }
        Node03 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.mahasiswa;
    }

    public Mahasiswa03 cariMaxIPK() {
        if (root == null) {
            return null;
        }
        Node03 current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.mahasiswa;
    }

    public void addRekursif(Mahasiswa03 mahasiswa) {
        root = addRekursifHelper(root, mahasiswa);
    }

    public Node03 addRekursifHelper(Node03 current, Mahasiswa03 mahasiswa) {
        if (current == null) {
            return new Node03(mahasiswa);
        }
        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = addRekursifHelper(current.left, mahasiswa);
        } else {
            current.right = addRekursifHelper(current.right, mahasiswa);
        }
        return current;
    }

    public void add(Mahasiswa03 mahasiswa) {
        Node03 newNode = new Node03(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node03 current = root;
            Node03 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;

                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node03 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node03 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node03 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node03 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node03 getSuccessor(Node03 del) {
        Node03 successor = del.right;
        Node03 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        Node03 parent = root;
        Node03 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;

            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node03 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
}