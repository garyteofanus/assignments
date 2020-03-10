package assignments.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsistenDosen {
    private List<Mahasiswa> mahasiswa = new ArrayList<>();
    private String kode;
    private String nama;

    public AsistenDosen(String kode, String nama) {
        // TODO: buat constructor untuk AsistenDosen.
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        // TODO: kembalikan kode AsistenDosen.
        return this.kode;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        // TODO: tambahkan mahasiswa ke dalam daftar mahasiswa dengan mempertahankan urutan.
        // Hint: kamu boleh menggunakan Collections.sort atau melakukan sorting manual.
        // Note: manfaatkan method compareTo pada Mahasiswa.
        this.mahasiswa.add(mahasiswa);
        Collections.sort(this.mahasiswa);
    }

    public Mahasiswa getMahasiswa(String npm) {
        // TODO: kembalikan objek Mahasiswa dengan NPM tertentu dari daftar mahasiswa.
        // Note: jika tidak ada, kembalikan null atau lempar sebuah Exception.
        if (mahasiswa.size() != 0) {
            for (Mahasiswa mahasiswa:
                    mahasiswa) {
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
             mahasiswa) {
            text.append(each).append("\n");
            text.append(each.rekap()).append("\n\n");
        }
        return text.toString();
    }

    public String toString() {
        return String.format("%s - %s", this.kode, this.nama);
    }
}
