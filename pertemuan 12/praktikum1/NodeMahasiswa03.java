
public class NodeMahasiswa03 {
    Mahasiswa03 data;
    NodeMahasiswa03 next;

    public NodeMahasiswa03(Mahasiswa03 data) {
        this.data = data;
        this.next = null;
    }

    public NodeMahasiswa03(Mahasiswa03 data, NodeMahasiswa03 next) {
        this.data = data;
        this.next = next;
    }
}
