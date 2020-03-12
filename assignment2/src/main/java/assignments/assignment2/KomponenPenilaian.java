package assignments.assignment2;

public class KomponenPenilaian {
    private String nama;
    private ButirPenilaian[] butirPenilaian;
    private int bobot;

    /**
     * Constructor for class KomponenPenilaian.
     * @param nama assignment name
     * @param banyakButirPenilaian number of individual score
     * @param bobot assignment weight to student final result
     */
    public KomponenPenilaian(String nama, int banyakButirPenilaian, int bobot) {
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
        this.butirPenilaian[idx] = butir;
    }

    public String getNama() {
        return this.nama;
    }

    /**
     * Get average score.
     * @return average score
     */
    public double getRerata() {
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
        return this.getRerata() * (bobot / 100.0);
    }

    /**
     * Summary of each individual score.
     * @return text with summary of each individual score
     */
    public String getDetail() {
        StringBuilder text = new StringBuilder(String.format("~~~ %s (%d%%) ~~~\n",
                this.nama, this.bobot));
        if (this.butirPenilaian.length == 1 && this.butirPenilaian[0] != null) {
            text.append(String.format("%s: %s\n", this.nama, this.butirPenilaian[0].toString()));
            text.append(String.format("Kontribusi nilai akhir: %.2f\n\n", this.getNilai()));
            return text.toString();
        } else {
            for (int i = 1; i <= this.butirPenilaian.length; i++) {
                if (this.butirPenilaian[i - 1] != null) {
                    text.append(String.format("%s %d: %s\n",
                            this.nama, i, this.butirPenilaian[i - 1].toString()));
                }
            }
            text.append(String.format("Rerata: %.2f\n", this.getRerata()));
            text.append(String.format("Kontribusi nilai akhir: %.2f\n\n", this.getNilai()));
            return text.toString();
        }
    }

    @Override
    public String toString() {
        return String.format("Rerata %s: %.2f", this.nama, this.getRerata());
    }

}
