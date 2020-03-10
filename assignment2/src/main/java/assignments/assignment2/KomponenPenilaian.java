package assignments.assignment2;

public class KomponenPenilaian {
    private String nama;
    private ButirPenilaian[] butirPenilaian;
    private int bobot;

    public KomponenPenilaian(String nama, int banyakButirPenilaian, int bobot) {
        // TODO: buat constructor untuk KomponenPenilaian.
        // Note: banyakButirPenilaian digunakan untuk menentukan panjang butirPenilaian saja
        // (tanpa membuat objek-objek ButirPenilaian-nya).
        this.nama = nama;
        this.bobot = bobot;
        this.butirPenilaian  = new ButirPenilaian[banyakButirPenilaian];
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
        this.butirPenilaian[idx] = butir;
    }

    public String getNama() {
        // TODO: kembalikan nama KomponenPenilaian.
        return this.nama;
    }

    public double getRerata() {
        // TODO: kembalikan rata-rata butirPenilaian.
        double sum = 0;
        int counter = 0;
        for (ButirPenilaian nilai:
                butirPenilaian) {
            if (nilai != null) {
                sum += nilai.getNilai();
                counter++;
            }
        }
        return counter == 0 ? 0 : (sum / counter);
    }

    public double getNilai() {
        // TODO: kembalikan rerata yang sudah dikalikan dengan bobot.
        return this.getRerata() * (bobot / 100.0);
    }

    public String getDetail() {
        // TODO: kembalikan detail KomponenPenilaian sesuai permintaan soal.
        StringBuilder text = new StringBuilder(String.format("~~~ %s (%d%%) ~~~\n", this.nama, this.bobot));
        if (this.butirPenilaian.length == 1 && this.butirPenilaian[0] != null) {
            text.append(String.format("%s: %s\n", this.nama, this.butirPenilaian[0].toString()));
            text.append(String.format("Kontribusi nilai akhir: %.2f\n\n", this.getNilai()));
            return text.toString();
        } else {
            for (int i = 1; i <= this.butirPenilaian.length; i++) {
                if (this.butirPenilaian[i-1] != null) {
                    text.append(String.format("%s %d: %s\n", this.nama, i, this.butirPenilaian[i-1].toString()));
                }
            }
            text.append(String.format("Rerata: %.2f\n", this.getRerata()));
            text.append(String.format("Kontribusi nilai akhir: %.2f\n\n", this.getNilai()));
            return text.toString();
        }
    }

    @Override
    public String toString() {
        // TODO: kembalikan representasi String sebuah KomponenPenilaian sesuai permintaan soal.
        return String.format("Rerata %s: %.2f", this.nama, this.getRerata());
    }

}
