package assignments.assignment2;

public class Mahasiswa implements Comparable<Mahasiswa> {
    private String npm;
    private String nama;
    private KomponenPenilaian[] komponenPenilaian;

    public Mahasiswa(String npm, String nama, KomponenPenilaian[] komponenPenilaian) {
        // TODO: buat constructor untuk Mahasiswa.
        // Note: komponenPenilaian merupakan skema penilaian yang didapat dari GlasDOS.
    }

    public KomponenPenilaian getKomponenPenilaian(String namaKomponen) {
        // TODO: kembalikan KomponenPenilaian yang bernama namaKomponen.
        // Note: jika tidak ada, kembalikan null atau lempar sebuah Exception.
        return null;
    }

    public String getNpm() {
        // TODO: kembalikan NPM mahasiswa.
        return "";
    }

    /**
     * Mengembalikan huruf berdasarkan nilai yang diberikan.
     * @param nilaiAkhir nilai untuk dicari hurufnya.
     * @return huruf dari nilai.
     */
    private static String getHuruf(double nilai) {
        return nilai >= 85 ? "A" :
            nilai >= 80 ? "A-" :
            nilai >= 75 ? "B+" :
            nilai >= 70 ? "B" :
            nilai >= 65 ? "B-" :
            nilai >= 60 ? "C+" :
            nilai >= 55 ? "C" :
            nilai >= 40 ? "D" : "E";
    }

    /**
     * Mengembalikan status kelulusan berdasarkan nilaiAkhir yang diberikan.
     * @param nilaiAkhir nilai akhir mahasiswa.
     * @return status kelulusan (LULUS/TIDAK LULUS).
     */
    private static String getKelulusan(double nilaiAkhir) {
        return nilaiAkhir >= 55 ? "LULUS" : "TIDAK LULUS";
    }

    public String rekap() {
        // TODO: kembalikan rekapan sesuai dengan permintaan soal.
        return "";
    }

    public String toString() {
        // TODO: kembalikan representasi String dari Mahasiswa sesuai permintaan soal.
        return "";
    }

    public String getDetail() {
        // TODO: kembalikan detail dari Mahasiswa sesuai permintaan soal.
        return "";
    }

    @Override
    public int compareTo(Mahasiswa other) {
        // TODO: definisikan cara membandingkan seorang mahasiswa dengan mahasiswa lainnya.
        // Hint: bandingkan NPM-nya, String juga punya method compareTo.
        return 0;
    }
}
