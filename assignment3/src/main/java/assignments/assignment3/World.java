package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

public class World{

    public List<Carrier> listCarrier;

    public World(){
        // TODO: Buat constructor untuk class World
        this.listCarrier = new ArrayList<>();
    }

    public Carrier createObject(String tipe, String nama){
        // TODO: Implementasikan apabila ingin membuat object sesuai dengan parameter yang diberikan
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

    public Carrier getCarrier(String nama){
        // TODO: Implementasikan apabila ingin mengambil object carrier dengan nama sesuai dengan parameter
        for (Carrier carrier : listCarrier) {
            if (carrier.getNama().equals(nama)) {
                return carrier;
            }
        }
        return null;
    }
}
