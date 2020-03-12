package assignments.assignment2;

public class Mahasiswa implements Comparable<Mahasiswa> {
    private String npm;
    private String nama;
    private KomponenPenilaian[] komponenPenilaian;

    /**
     * Constructor for class Mahasiswa.
     *
     * @param npm student's NPM
     * @param nama student's name
     * @param komponenPenilaian student's score sheet that consist of ButirPenilaian object
     */
    public Mahasiswa(String npm, String nama, KomponenPenilaian[] komponenPenilaian) {
        this.npm = npm;
        this.nama = nama;
        this.komponenPenilaian = komponenPenilaian;
    }

    /**
     *  Find matching KomponenPenilaian object.
     *
     * @param namaKomponen name of LomponenPenilaian object
     * @return KomponenPenilaian object that matches the parameter name, null if not found
     */
    public KomponenPenilaian getKomponenPenilaian(String namaKomponen) {
        for (KomponenPenilaian komponen :
                komponenPenilaian) {
            if (komponen.getNama().equalsIgnoreCase(namaKomponen)) {
                return komponen;
            }
        }
        return null;
    }

    public String getNpm() {
        return this.npm;
    }

    /**
     * Returning letter according total score.
     *
     * @param nilai score to calculate the letter
     * @return letter from score
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
     * Returning graduating status according to given score.
     *
     * @param nilaiAkhir end result of student's score
     * @return graduating status (LULUS / TIDAK LULUS)
     */
    private static String getKelulusan(double nilaiAkhir) {
        return nilaiAkhir >= 55 ? "LULUS" : "TIDAK LULUS";
    }

    /**
     * Summary of all students data.
     *
     * @return string containing all score components with end results,
     *     letter score, and final result
     */
    public String rekap() {
        StringBuilder text = new StringBuilder();
        double nilaiAkhir = 0;
        for (KomponenPenilaian nilai :
                komponenPenilaian) {
            text.append(nilai).append("\n");
            nilaiAkhir += nilai.getNilai();
        }
        text.append(String.format("Nilai akhir: %.2f\n", nilaiAkhir));
        text.append(String.format("Huruf: %s\n", getHuruf(nilaiAkhir)));
        text.append(String.format("%s\n\n", getKelulusan(nilaiAkhir)));
        return text.toString();
    }

    public String toString() {
        return String.format("%s - %s", this.npm, this.nama);
    }

    /**
     * Get detailed info about each student.
     * @return text containing detailed info of each student
     */
    public String getDetail() {
        StringBuilder text = new StringBuilder();
        double nilaiAkhir = 0;
        for (KomponenPenilaian nilai :
                komponenPenilaian) {
            text.append(nilai.getDetail());
            nilaiAkhir += nilai.getNilai();
        }
        text.append(String.format("Nilai akhir: %.2f\n", nilaiAkhir));
        text.append(String.format("Huruf: %s\n", getHuruf(nilaiAkhir)));
        text.append(String.format("%s", getKelulusan(nilaiAkhir)));
        return text.toString();
    }

    @Override
    public int compareTo(Mahasiswa other) {
        if (this.npm.compareTo(other.getNpm()) > 0) {
            return 1;
        } else if (this.npm.compareTo(other.getNpm()) < 0) {
            return -1;
        }
        return 0;
    }
}
