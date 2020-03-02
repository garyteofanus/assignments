package assignments.assignment2;

import java.util.ArrayList;
import java.util.List;

public class AsistenDosen {
    private List<Mahasiswa> mahasiswa = new ArrayList<>();
    private String kode;
    private String nama;

    public AsistenDosen(String kode, String nama) {
        // TODO: buat constructor untuk AsistenDosen.
    }

    public String getKode() {
        // TODO: kembalikan kode AsistenDosen.
        return "";
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        // TODO: tambahkan mahasiswa ke dalam daftar mahasiswa dengan mempertahankan urutan.
        // Hint: kamu boleh menggunakan Collections.sort atau melakukan sorting manual.
        // Note: manfaatkan method compareTo pada Mahasiswa.
    }

    public Mahasiswa getMahasiswa(String npm) {
        // TODO: kembalikan objek Mahasiswa dengan NPM tertentu dari daftar mahasiswa.
        // Note: jika tidak ada, kembalikan null atau lempar sebuah Exception.
        return null;
    }

    public String rekap() {
        return "";
    }

    public String toString() {
        return "";
    }
}
