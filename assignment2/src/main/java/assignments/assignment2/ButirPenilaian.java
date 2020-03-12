package assignments.assignment2;

public class ButirPenilaian {
    private static final int PENALTI_KETERLAMBATAN = 20;
    private double nilai;
    private boolean terlambat;

    /**
     * Constructor for class ButirPenilaian.
     * @param nilai individual score, when value for nilai is less than 0, set as 0
     * @param terlambat true if submission is late, else false
     */
    public ButirPenilaian(double nilai, boolean terlambat) {
        if (nilai < 0) {
            this.nilai = 0;
        } else {
            this.nilai = nilai;
        }
        this.terlambat = terlambat;
    }

    /**
     * Get individual score value.
     * @return score value with 20% reduce when late
     */
    public double getNilai() {
        if (this.terlambat) {
            return this.nilai * 0.8;
        }
        return this.nilai;
    }

    @Override
    public String toString() {
        if (this.terlambat) {
            return String.format("%.2f (T)", getNilai());
        }
        return String.format("%.2f", getNilai());
    }
}
