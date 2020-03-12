package assignments.assignment2;

import java.util.Scanner;

public class GlasDOS {
    private static final int INPUT_NUM = 1;
    private static final int DETAIL_NUM = 2;
    private static final int REKAP_NUM = 3;
    private static final int UBAH_KODE_ASDOS_NUM = 4;
    private static final int KELUAR_NUM = 99;
    private AsistenDosen[] asistenDosen;
    private KomponenPenilaian[] templatSkemaPenilaian;
    private Scanner input = new Scanner(System.in);

    private void initPesan() {
        System.out.println("Selamat datang di Global Asdos Data Organizing System!");
        System.out.println("====================== GlasDOS =======================");
        System.out.println();
    }

    private void initSkemaPenilaian() {
        System.out.println("Mari buat skema penilaian!");
        System.out.println("Masukkan banyaknya komponen penilaian:");
        int numKomponen = Integer.parseInt(input.nextLine());
        templatSkemaPenilaian = new KomponenPenilaian[numKomponen];
        for (int i = 1; i <= numKomponen; i++) {
            System.out.println("> Komponen Penilaian " + i);
            System.out.println("Masukkan nama komponen penilaian " + i + ": ");
            String namaKomponen = input.nextLine();
            System.out.println("Masukkan banyaknya butir penilaian " + namaKomponen + ":");
            int numButir = Integer.parseInt(input.nextLine());
            System.out.println("Masukkan bobot penilaian " + namaKomponen + " (dalam persen):");
            int bobot = Integer.parseInt(input.nextLine());
            templatSkemaPenilaian[i - 1] = new KomponenPenilaian(namaKomponen, numButir, bobot);
        }
        System.out.println("Skema penilaian berhasil dibuat!");
        System.out.println();
    }

    private void initAsdosMahasiswa() {
        System.out.println("Mari masukkan data asdos dan mahasiswa!");
        System.out.println("Masukkan banyaknya asdos:");
        int numAsistenDosen = Integer.parseInt(input.nextLine());
        asistenDosen = new AsistenDosen[numAsistenDosen];
        for (int i = 1; i <= numAsistenDosen; i++) {
            System.out.println("Data asdos " + i + ":");
            String[] dataAsdos = input.nextLine().split(" ", 2);
            AsistenDosen newAsdos = new AsistenDosen(dataAsdos[0], dataAsdos[1]);
            asistenDosen[i - 1] = newAsdos;
            System.out.println("Masukkan banyaknya mahasiswa dengan kode asdos "
                    + dataAsdos[0] + ":");
            int numAsdosan = Integer.parseInt(input.nextLine());
            for (int j = 1; j <= numAsdosan; j++) {
                System.out.println("Data mahasiswa " + j + ":");
                String[] dataMhs = input.nextLine().split(" ", 2);
                KomponenPenilaian[] skema = KomponenPenilaian.salinTemplat(templatSkemaPenilaian);
                Mahasiswa baru = new Mahasiswa(dataMhs[0], dataMhs[1], skema);
                newAsdos.addMahasiswa(baru);
            }
        }
        System.out.println();
    }

    /**
     * Get teaching assistant that match the given code.
     * @param kode teaching assistant code to be searched
     * @return object AsistenDosen, else null
     */
    private AsistenDosen getAsistenDosen(String kode) {
        for (AsistenDosen asdos:
             asistenDosen) {
            if (asdos.getKode().equalsIgnoreCase(kode)) {
                return asdos;
            }
        }
        return null;
    }

    /**
     * Get student that match the given NPM and teaching assistant code.
     * @param kodeAsdos teaching assistant code
     * @param npm student's NPM
     * @return object Mahasiswa, else null
     */
    private Mahasiswa getMahasiswa(String kodeAsdos, String npm) {
        if (this.getAsistenDosen(kodeAsdos) != null) {
            return this.getAsistenDosen(kodeAsdos).getMahasiswa(npm);
        }
        return null;
    }

    /**
     * Get score sheet that match given teaching assistant code, student's NPM,
     *      and score component name.
     * @param kodeAsdos teaching assistant code
     * @param npm student's NPM
     * @param namaKomponen score component's name
     * @return object KomponenPenilaian, else null
     */
    private KomponenPenilaian getKomponenPenilaian(String kodeAsdos,
                                                   String npm, String namaKomponen) {
        if (this.getMahasiswa(kodeAsdos, npm) != null) {
            return this.getMahasiswa(kodeAsdos, npm).getKomponenPenilaian(namaKomponen);
        }
        return null;
    }

    private void menuInput() {
        System.out.println("--- Input nilai ---");
        System.out.println("Masukkan perintah input nilai dalam format berikut:");
        System.out.println(
            "[KodeAsdos] [NPM] [KomponenPenilaian] [NomorButirPenilaian] [Nilai] [Terlambat]"
        );
        System.out.println("Contoh: SMA 1234567890 Lab 1 90.00 true");
        System.out.println("Jika sudah selesai, tulis SELESAI dan tekan tombol Enter.");
        System.out.println();
        while (!input.hasNext("(?i)SELESAI")) {
            String[] masukan = input.nextLine().split(" ");
            String kodeAsdos = masukan[0];
            String npm = masukan[1];
            String namaKomponen = masukan[2];
            int idx = Integer.parseInt(masukan[3]);
            double nilaiButir = Double.parseDouble(masukan[4]);
            boolean terlambat = Boolean.parseBoolean(masukan[5]);
            ButirPenilaian butir = new ButirPenilaian(nilaiButir, terlambat);
            KomponenPenilaian komponenPenilaian = getKomponenPenilaian(kodeAsdos,
                    npm, namaKomponen);
            if (komponenPenilaian != null) {
                komponenPenilaian.masukkanButirPenilaian(idx - 1, butir);
            } else {
                System.out.println(
                    "Komponen penilaian untuk NPM " + npm + " pada kode asdos "
                    + kodeAsdos + " tidak ditemukan!"
                );
            }
        }
        input.nextLine();
        System.out.println("Sukses! Kembali ke menu utama...");
        System.out.println();
    }

    private void menuDetail() {
        System.out.println("--- Lihat detail nilai mahasiswa ---");
        System.out.println("Masukkan data mahasiswa dalam format berikut:");
        System.out.println("[KodeAsdos] [NPM]");
        System.out.println("Contoh: SMA 134567890");
        System.out.println();
        String[] dataMhs = input.nextLine().split(" ");
        Mahasiswa mahasiswa = getMahasiswa(dataMhs[0], dataMhs[1]);
        if (mahasiswa != null) {
            System.out.println(mahasiswa);
            System.out.println(mahasiswa.getDetail());
        } else {
            System.out.println("Mahasiswa dengan kode asdos dan NPM tersebut tidak ditemukan!");
        }
        System.out.println();
        System.out.println("Kembali ke menu utama...");
        System.out.println();
    }

    private void menuRekap() {
        System.out.println("--- Rekap ---");
        for (AsistenDosen asdos : asistenDosen) {
            System.out.println(asdos);
            System.out.println("~".repeat(asdos.toString().length()));
            System.out.println();
            System.out.println(asdos.rekap());
        }
        System.out.println("Kembali ke menu utama...");
        System.out.println();
    }

    private void menuUbahAsdos() {
        System.out.println("--- Ubah kode asdos mahasiswa ---");
        System.out.println("Masukan input kode asdos yang baru dengan format berikut:");
        System.out.println("[KodeAsdosAsal] [NPM] [KodeAsdosBaru]");
        System.out.println("Contoh: SMA 1234567890 SMP");
        System.out.println();
        String[] data = input.nextLine().split(" ");
        if (this.getAsistenDosen(data[0]) == null && this.getAsistenDosen(data[2]) == null) {
            System.out.println(String.format("Asdos dengan kode %s dan %s tidak ditemukan!",
                    data[0], data[2]));
        } else if (this.getAsistenDosen(data[0]) == null) {
            System.out.println(String.format("Asdos dengan kode %s tidak ditemukan!", data[0]));
        } else if (this.getAsistenDosen(data[2]) == null) {
            System.out.println(String.format("Asdos dengan kode %s tidak ditemukan!", data[2]));
        } else if (this.getMahasiswa(data[0], data[1])
                == null) {
            System.out.println(String.format("Mahasiswa dengan NPM %s tidak ditemukan di asdos %s!",
                    data[1], data[0]));
        } else {
            this.getAsistenDosen(data[2]).addMahasiswa(this.getMahasiswa(data[0], data[1]));
            this.getAsistenDosen(data[0]).removeMahasiswa(this.getMahasiswa(data[2], data[1]));
            System.out.println("Sukses! Kembali ke menu utama...");
        }
    }

    private void menu() {
        int operation;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("=== Menu utama ===");
            System.out.println("1. Input nilai");
            System.out.println("2. Lihat detail nilai mahasiswa");
            System.out.println("3. Rekap");
            System.out.println("4. Ubah kode asdos mahasiswa");
            System.out.println("99. Keluar");
            System.out.println("Masukkan pilihan menu:");
            try {
                operation = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();
            if (operation == INPUT_NUM) {
                menuInput();
            } else if (operation == DETAIL_NUM) {
                menuDetail();
            } else if (operation == REKAP_NUM) {
                menuRekap();
            } else if (operation == UBAH_KODE_ASDOS_NUM) {
                menuUbahAsdos();
            } else if (operation == KELUAR_NUM) {
                System.out.println("Terima kasih telah menggunakan GlasDOS!");
                hasChosenExit = true;
            }
        }
    }

    private void run() {
        initPesan();
        initSkemaPenilaian();
        initAsdosMahasiswa();
        System.out.println("Inisialisasi selesai!");
        System.out.println();
        menu();
        input.close();
    }

    public static void main(String[] args) {
        GlasDOS program = new GlasDOS();
        program.run();
    }
}
