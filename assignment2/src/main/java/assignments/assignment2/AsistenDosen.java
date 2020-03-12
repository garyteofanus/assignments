package assignments.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsistenDosen {
    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private String kode;
    private String nama;

    public AsistenDosen(String kode, String nama) {
        // Membuat constructor untuk AsistenDosen.
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        // Mengembalikan kode AsistenDosen.
        return this.kode;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        // Menambahkan mahasiswa ke dalam daftar mahasiswa dengan mempertahankan urutan menggunakan
        // Collection.sort
        this.mahasiswas.add(mahasiswa);
        Collections.sort(this.mahasiswas);
    }

    public void removeMahasiswa(Mahasiswa mahasiswa) {
        // Menghilangkan mahasiswa dari daftar asdos
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (mahasiswas.get(i) == mahasiswa) {
                mahasiswas.remove(i);
                break;
            }
        }
        Collections.sort(mahasiswas); // Just to make sure
    }

    public Mahasiswa getMahasiswa(String npm) {
        // Mengembalikan objek Mahasiswa dengan NPM tertentu dari daftar mahasiswa.
        if (mahasiswas.size() != 0) {
            for (Mahasiswa mahasiswa:
                    mahasiswas) {
                if (mahasiswa.getNpm().equals(npm)) {
                    return mahasiswa;
                }
            }
        }
        return null;
    }

    public String rekap() {
        int total = this.kode.length() + this.nama.length() + 3;
        StringBuilder text = new StringBuilder();
        text.append("~".repeat(Math.max(0, total))).append("\n\n");
        for (Mahasiswa each:
                mahasiswas) {
            text.append(each).append("\n");
            text.append(each.rekap()).append("\n\n");
        }
        return text.toString();
    }

    public String toString() {
        return String.format("%s - %s", this.kode, this.nama);
    }
}
