package pertemuan14;

public class BinaryTreeArray03 {
    Mahasiswa03[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray03() {
        this.dataMahasiswa = new Mahasiswa03[10];
    }

    void populateData(Mahasiswa03 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
}

