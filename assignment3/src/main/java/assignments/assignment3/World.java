package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

public class World {

    public List<Carrier> listCarrier;

    /**
     * Constructor for World class.
     */
    public World() {
        this.listCarrier = new ArrayList<>();
    }

    /**
     * Create object according to it's given name and type.
     * @param tipe Carrier type
     * @param nama Carrier name
     * @return Carrier object with given name and type.
     */
    public Carrier createObject(String tipe, String nama) {
        switch (tipe.toUpperCase()) {
            case "ANGKUTAN_UMUM":
                return new AngkutanUmum(nama);
            case "CLEANING_SERVICE":
                return new CleaningService(nama);
            case "JURNALIS":
                return new Jurnalis(nama);
            case "OJOL":
                return new Ojol(nama);
            case "PEGANGAN_TANGGA":
                return new PeganganTangga(nama);
            case "PEKERJA_JASA":
                return new PekerjaJasa(nama);
            case "PETUGAS_MEDIS":
                return new PetugasMedis(nama);
            case "PINTU":
                return new Pintu(nama);
            case "TOMBOL_LIFT":
                return new TombolLift(nama);
            default:
                return null;
        }
    }

    /**
     * Search carrier object from it's name.
     * @param nama Name of carrier to be searched
     */
    public Carrier getCarrier(String nama) {
        for (Carrier carrier : listCarrier) {
            if (carrier.getNama().equals(nama)) {
                return carrier;
            }
        }
        return null;
    }
}
