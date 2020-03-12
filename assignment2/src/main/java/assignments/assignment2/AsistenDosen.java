package assignments.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsistenDosen {
    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private String nama;
    private String kode;

    /**
     * Constructor for class AsistenDosen.
     * @param kode teaching assitant code
     * @param nama teaching assistant name
     */
    public AsistenDosen(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return this.kode;
    }

    /**
     * Add student to list of student of certain teaching assistant and
     *      sort them according to NPM.
     * @param mahasiswa object mahasiswa to be added
     */
    public void addMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswas.add(mahasiswa);
        Collections.sort(this.mahasiswas);
    }

    /**
     * Remove student from list of student of certain teaching assistant.
     * @param mahasiswa object mahasiswa to be removed
     */
    public void removeMahasiswa(Mahasiswa mahasiswa) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (mahasiswas.get(i) == mahasiswa) {
                mahasiswas.remove(i);
                break;
            }
        }
        Collections.sort(mahasiswas); // Just to make sure
    }

    /**
     * Get object mahasiswa that match the given NPM.
     * @param npm students's NPM
     * @return object mahasiswa that match the given NPM, else null
     */
    public Mahasiswa getMahasiswa(String npm) {
        if (mahasiswas.size() != 0) {
            for (Mahasiswa mahasiswa :
                    mahasiswas) {
                if (mahasiswa.getNpm().equals(npm)) {
                    return mahasiswa;
                }
            }
        }
        return null;
    }

    /**
     * Get summary of each teaching assistant's student.
     * @return text with summary of each teaching assistant's student
     */
    public String rekap() {
        StringBuilder text = new StringBuilder();
        for (Mahasiswa each :
                mahasiswas) {
            text.append(each).append("\n");
            text.append(each.rekap());
        }
        return text.toString();
    }

    public String toString() {
        return String.format("%s - %s", this.kode, this.nama);
    }
}
