package assignments.assignment2;

public class KomponenPenilaian {
    private String nama;
    private ButirPenilaian[] butirPenilaian;
    private int bobot;

    public KomponenPenilaian(String nama, int banyakButirPenilaian, int bobot) {
        // TODO: buat constructor untuk KomponenPenilaian.
        // Note: banyakButirPenilaian digunakan untuk menentukan panjang butirPenilaian saja
        // (tanpa membuat objek-objek ButirPenilaian-nya).
    }

    /**
     * Membuat objek KomponenPenilaian baru berdasarkan bentuk KomponenPenilaian templat.
     * @param templat templat KomponenPenilaian.
     */
    private KomponenPenilaian(KomponenPenilaian templat) {
        this(templat.nama, templat.butirPenilaian.length, templat.bobot);
    }

    /**
     * Mengembalikan salinan skema penilaian berdasarkan templat yang diberikan.
     * @param templat templat skema penilaian sebagai sumber.
     * @return objek baru yang menyerupai templat.
     */
    public static KomponenPenilaian[] salinTemplat(KomponenPenilaian[] templat) {
        KomponenPenilaian[] salinan = new KomponenPenilaian[templat.length];
        for (int i = 0; i < salinan.length; i++) {
            salinan[i] = new KomponenPenilaian(templat[i]);
        }
        return salinan;
    }

    public void masukkanButirPenilaian(int idx, ButirPenilaian butir) {
        // TODO: masukkan butir ke butirPenilaian pada index ke-idx.
    }

    public String getNama() {
        // TODO: kembalikan nama KomponenPenilaian.
        return "";
    }

    public double getRerata() {
        // TODO: kembalikan rata-rata butirPenilaian.
        return 0;
    }

    public double getNilai() {
        // TODO: kembalikan rerata yang sudah dikalikan dengan bobot.
        return 0;
    }

    public String getDetail() {
        // TODO: kembalikan detail KomponenPenilaian sesuai permintaan soal.
        return "";
    }

    @Override
    public String toString() {
        // TODO: kembalikan representasi String sebuah KomponenPenilaian sesuai permintaan soal.
        return "";
    }

}
