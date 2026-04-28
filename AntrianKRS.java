package smt2.jobsheet10;

public class AntrianKRS {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS;
    int maxDPA;

    public AntrianKRS(int max, int maxDPA) {
        this.max = max;
        this.maxDPA = maxDPA;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void kosongkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian sudah kosong.");
        } else {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        }
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh (max " + max + "), tidak dapat menambah mahasiswa.");
            return;
        }
        if (sudahKRS >= maxDPA) {
            System.out.println("DPA sudah menangani " + maxDPA + " mahasiswa. Tidak bisa menambah antrian.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian. Nomor antrian: " + size);
    }

    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk diproses.");
            return;
        }
        System.out.println("=== Memanggil antrian untuk proses KRS ===");
        int jumlahDipanggil = Math.min(2, size); // panggil 2 atau sisa jika < 2
        for (int i = 0; i < jumlahDipanggil; i++) {
            if (sudahKRS >= maxDPA) {
                System.out.println("DPA sudah mencapai batas maksimal " + maxDPA + " mahasiswa.");
                break;
            }
            Mahasiswa mhs = data[front];
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            System.out.print("Mahasiswa ke-" + sudahKRS + " diproses KRS: ");
            mhs.tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar semua antrian:");
        System.out.println("No. NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkan2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 antrian terdepan:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int jumlah = Math.min(2, size);
        for (int i = 0; i < jumlah; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling akhir:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }

    public void cetakJumlahAntrian() {
        System.out.println("Jumlah antrian saat ini: " + size);
    }

    public void cetakSudahKRS() {
        System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + sudahKRS);
    }

    public void cetakBelumKRS() {
        // Total yang pernah masuk antrian = sudahKRS + size (yang masih antri)
        // Mahasiswa yang belum KRS = yang masih di antrian
        System.out.println("Jumlah mahasiswa yang belum proses KRS (masih antri): " + size);
        int sisaKapasitasDPA = maxDPA - sudahKRS;
        System.out.println("Sisa kapasitas DPA: " + sisaKapasitasDPA + " mahasiswa");
    }

    public int getJumlahAntrian() {
        return size;
    }
}
