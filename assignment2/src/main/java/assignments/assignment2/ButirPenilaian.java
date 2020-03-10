package assignments.assignment2;

public class ButirPenilaian {
    private static final int PENALTI_KETERLAMBATAN = 20;
    private double nilai;
    private boolean terlambat;

    public ButirPenilaian(double nilai, boolean terlambat) {
        // TODO: buat constructor untuk ButirPenilaian.
        if (nilai < 0) {
            this.nilai = 0;
        } else {
            this.nilai = nilai;
        }
        this.terlambat = terlambat;
    }

    public double getNilai() {
        // TODO: kembalikan nilai yang sudah disesuaikan dengan keterlambatan.
        if (this.terlambat) {
            return this.nilai * 0.8;
        }
        return this.nilai;
    }

    @Override
    public String toString() {
        // TODO: kembalikan representasi String dari ButirPenilaian sesuai permintaan soal.
        if (this.terlambat) {
            return String.format("%.2f (T)", getNilai());
        }
        return String.format("%.2f", getNilai());
    }
}
