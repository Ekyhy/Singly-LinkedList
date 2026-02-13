import java.util.Scanner;

class Node {
    String nimMahasiswa;
    String namaMahasiswa;
    Node next;

    public Node(String nimMahasiswa, String namaMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.next = null;
    }
}

class MahasiswaLinkedList {
    private Node head;

    public int countNodes(){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void tambahBelakang(String nimMahasiswa, String namaMahasiswa) {
        Node nodeBaru = new Node(nimMahasiswa, namaMahasiswa);

        if (head == null) {
            head = nodeBaru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nodeBaru;
        }
    }

    public void tambahDepan(String nimMahasiswa, String namaMahasiswa) {
        Node nodeBaru = new Node(nimMahasiswa,namaMahasiswa);

        if (head == null){
            head = nodeBaru;
        } else{
            nodeBaru.next = head;
            head =  nodeBaru;
        }
    }

    public void tambahPosisiPilihan(int posisi,String nimMahasiswa, String namaMahasiswa){
        int count = countNodes();

        if (posisi < 1 || posisi > count + 1){
            System.out.println("Posisi tidak valid! Range: 1 -" + (count + 1));
        }

        Node nodeBaru = new Node(nimMahasiswa, namaMahasiswa);

        if(posisi == 1){
            nodeBaru.next = head;
            head = nodeBaru;
            return;
        }

        Node current = head;
        for(int i = 1; i < posisi-1; i++){
            current = current.next;
        }

        nodeBaru.next = current.next;
        current.next = nodeBaru;
    }

    public void hapusDataDepan(String nimMahasiswa, String namaMahasiswa){
        if (head == null){
            System.out.println("Daftar kosong, tidak ada yang bisa dihapus.");
            return;
        }
        System.out.println("Menghapus mahasiswa: " + head.namaMahasiswa);

        head =  head.next;
    }

    public void hpusDataPilihan(int posisi){
        int count = countNodes();

        if (head ==  null) {
            System.out.println("Daftar Mahasiswa Kosong");
            return;
        }

        if (posisi < 1 || posisi > count) {
            System.out.println("Posisi Tidak Valid! Range yang tersedia: 1 -" + count);
            return;
        }

        if (posisi == 1) {
            System.out.println("Menghapus" + head.namaMahasiswa + "Pada Posisi " + posisi);
            head = head.next;
        }

        Node current = head;
        for(int i = 1; i < posisi; i++){
            current = current.next;
        }

        System.out.println("Menghapus" + current.next.namaMahasiswa + "pada posisis" + posisi);

        current.next = current.next.next;
    }

    public void hapusDataBelakang(){
        if (head == null) {
            return;
        }

        Node hapusDataBelakang = head;
        while (hapusDataBelakang.next.next != null) {
            hapusDataBelakang = hapusDataBelakang.next;
        }

        hapusDataBelakang.next = null;
    }

    public  void hapusDataDariNim(String nimTarget){
        if (head == null) {
            System.out.println("Datar Kosong!");
            return;
        }

        if (head.nimMahasiswa.equals(nimTarget)) {
            System.out.println("Mahasiswa Dengan NIM: ["+ nimTarget + "] [ Nama: " + head.namaMahasiswa + "]. Telah Di Hapus!");
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.nimMahasiswa.equals(nimTarget)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Mahasiswa Dengan NIM: " + nimTarget + " Tidak Dapat Ditemukan!");
            return;
        }

        System.out.println("Mahasiwa Dengan NIM: " + nimTarget + " [Nama: " + current.namaMahasiswa + "] Berhasil Dihapus!");
        previous.next = current.next;
    }

    public void tampilan() {
        if (head == null) {
            System.out.println("Daftar Mahasiswa Kosong");
            return;
        }

        Node temp = head;
        System.out.println("==== Daftar Mahasiswa ====");
        while (temp != null) {
            System.out.println("NIM: " + temp.nimMahasiswa + " | Nama: " + temp.namaMahasiswa);
            temp = temp.next;
        }
    }
}

public class taskTwo {
    public static void main(String[] args) {
        MahasiswaLinkedList listMhs = new MahasiswaLinkedList();

        Scanner scanner = new Scanner(System.in);
        int pilihanMenu;

        System.out.println("=== Menu Program Olah Data Mahasiswa ===");
        do {
            System.out.println("Pilih Menu: ");
            System.out.println("1. Data baru ditempatkan di depan: ");
            System.out.println("2. Data baru ditempatkan di posisi sesuai pilihan (1 - count + 1): ");
            System.out.println("3. Data baru ditempatkan di belakang: ");
            System.out.println("4. Hapus data paling depan: ");
            System.out.println("5. Hapus data di posisi sesuai pilihan (1 - count): ");
            System.out.println("6. Hapus data paling belakang: ");
            System.out.println("7. Hapus data mahasiswa berdasarkan input user (NIM): ");
            System.out.println("8. Tampilkan seluruh data mahasiswa: ");
            System.err.println("9. Keluar dari program");
            System.out.println("=========================================");
            System.out.println("Masukan pilihan menu: ");

            pilihanMenu =  scanner.nextInt();
            scanner.nextLine();
            switch (pilihanMenu) {
                case 1:
                    System.out.println("==== Tamabah Data Mahasiswa di Depan ====");
                    System.out.println("Masukkan NIM Mahasiswa: ");
                    String nimBaruDepan = scanner.nextLine();
                    System.out.println("Masukkan Nama Mahasiwa: ");
                    String namaBaruDepan = scanner.nextLine();

                    listMhs.tambahDepan(nimBaruDepan, namaBaruDepan );
                    break;
                case 2:
                    System.out.println("==== Data Baru Ditempatkan Di Posisi Sesuai Pilihan (1 - count + 1)====");
                    System.out.println("Masukkan Posisi Mahasiswa Baru: (1 - " + (listMhs.countNodes() + 1 +"): "));
                    int posisiMahasiswaTambahPilihan = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Masukkan NIM Mahasiswa: ");
                    String nimTambahPilihan = scanner.nextLine();
                    System.out.println("Masukkan Nama Mahasiwa: ");
                    String namaTambahPilihan = scanner.nextLine();

                    listMhs.tambahPosisiPilihan(posisiMahasiswaTambahPilihan, nimTambahPilihan, namaTambahPilihan);
                    break;
                case 3:
                    System.out.println("==== Tambah Data Mahasiswa di Belakang ====");

                    System.out.println("Masukkan NIM Mahasiswa: ");
                    String nimBaruBelakang = scanner.nextLine();
                    
                    System.out.println("Masukkan Nama Mahasiswa: ");
                    String namaBaruBelakang = scanner.nextLine();
                    

                    listMhs.tambahBelakang(nimBaruBelakang, namaBaruBelakang);
                    System.out.println("Data Mahasiswa Berhasil Ditambahkan di Belakang");
                    break;
                case 4: 
                    System.out.println("==== Hapus Data Paling Depan ====");
                    listMhs.hapusDataDepan(" "," ");
                    break;
                case 5:
                    System.out.println("==== Hapus Data Di posisi Sesuai Pilihan (1 - counut) ====");
                    System.out.println("Masukkan Posisi Mahasiswa Dihapus: (1 - " + (listMhs.countNodes() + "): "));

                    int hapusPosisiData = scanner.nextInt();

                    listMhs.hpusDataPilihan(hapusPosisiData);

                    break;
                case 6:
                    System.out.println("==== Hapus Data Dari Belakang ===-");
                    listMhs.hapusDataBelakang();
                    break;

                case 7:
                    System.out.println(" ==== Hapus data mahasiswa berdasarkan input user (NIM) ==== ");

                    System.out.println("Masukkan NIM yang akan di hapus: ");
                    String nimHapusData = scanner.nextLine();
                    listMhs.hapusDataDariNim(nimHapusData);

                    break;

                case 8:
                    System.out.println("==== Tampilan Data Mahasiswa Sekarang ====");
                    listMhs.tampilan();
                    System.out.println("=========================================");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (pilihanMenu != 0);
    }
}