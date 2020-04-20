# Tugas Pemrograman 3: Corona

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2019/2020

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan
Tugas Pemrograman 3 mata kuliah DDP 2. Tugas Pemrograman ini didesain untuk
mengimplementasikan konsep Pemrograman Berorientasi Objek dengan memanfaatkan abstract class dan interfaces. Serta melakukan Exception handling dan text I/O.

Tugas Pemrograman ini mencakup materi berikut:

- Materi yang dicakup Tugas Pemrograman 2
- *Abstract Classes*
- *Interfaces*
- *Exception Handling*
- *Text I/O*

## Daftar Isi

1. [Latar belakang dan deskripsi](#latar-belakang-dan-deskripsi)
2. [Persiapan](#persiapan)
3. [Menjalankan dan menguji program](#menjalankan-dan-menguji-program)
4. [Pengumpulan](#pengumpulan)
5. [Daftar pekerjaan](#daftar-pekerjaan)
   1. [Daftar pekerjaan wajib](#daftar-pekerjaan-wajib)
   2. [Daftar pekerjaan bonus (opsional)](#daftar-pekerjaan-bonus-opsional)
6. [Penilaian](#penilaian)


## Latar belakang dan deskripsi

Silakan baca [dokumen soal][dokumen tp2].

## Persiapan

Lakukan `git pull upstream master` seperti yang diinstruksikan pada
[`README.md`][root-readme] di *root* repositori ini. Lalu, silakan kerjakan
soal menggunakan *starter code* yang disediakan.

## Menjalankan dan menguji program

> Catatan: ubah `gradlew.bat` dengan `./gradlew` dan `\` dengan `/` jika kamu
> menggunakan Linux/Mac.

Kamu bisa menjalankan beberapa *task* dengan Gradle melalui IDE atau
terminal/Command Prompt.

Untuk menjalankan program:

```bash
> gradlew.bat :assignment3:run --console plain --quiet
```

Untuk menguji program dengan *unit test* yang disediakan:

```bash
> gradlew.bat :assignment3:test
```

> Tips: kamu bisa memeriksa hasil *unit test* dalam bentuk dokumen HTML. Lihat dokumen
> HTML tersebut di dalam folder `build\reports` yang ada di direktori ini.

Untuk melihat output program dengan *test case* input yang disediakan:

```bash
> gradlew.bat :assignment3:run --console plain --quiet < assignment3\testcases\InputTC1.txt
> gradlew.bat :assignment3:run --console plain --quiet < assignment3\testcases\InputTC2.txt
```

Kamu bisa membandingkan *output*-nya dengan berkas berawalan `OutputTC` yang ada di direktori
[testcases][testcases].

*Hint*: kamu juga bisa menggunakan `>` untuk menyimpan output ke dalam sebuah *file*.

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya (Dalam hal ini adalah Simulator.java).

```bash
> cd src\main\java
src\main\java> javac assignments\assignment3\*.java
src\main\java> java assignments.assignment3.Simulator
```

## Pengumpulan

Simpan pekerjaan kamu, lalu lakukan `add`, `commit`, dan `push` dengan Git.
*Push* solusi kamu **sebelum [Taruh tanggal disini] pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.

Jangan lupa bahwa ada pengumpulan secara terpisah di SCeLE untuk Class Diagram
dengan *deadline* yang sama. Untuk lebih detailnya, silakan lihat dokumen soal
dan SCeLE.

## Daftar pekerjaan

### Daftar pekerjaan wajib

- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 2.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan *class* `World` dengan benar.
- [ ] Implementasikan *class* `InputOutput` dengan benar.
- [ ] Implementasikan *class* `Carrier` dengan benar.
- [ ] Implementasikan *class* `Status` dengan benar.
- [ ] Implementasikan *class* `Benda` dengan benar.
- [ ] Implementasikan *class* `Manusia` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Benda`, yaitu `AngkutanUmum`, `PeganganTangga`, `Pintu`, dan `TombolLift` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Manusia`, yaitu `CleaningService`, `Jurnalis`, `PekerjaJasa`, `PetugasMedis`, dan `Ojol` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Status`, yaitu `Positif` dan `Negatif` dengan benar.
- [ ] Implementasikan *class* `BelumTertularException` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

## Penilaian TODO

- 10% Class Diagram dalam Unified Modeling Language (UML)
- 50% kebenaran program
- 30% demonstrasi program
- 10% kerapian dan dokumentasi
- +5% implementasi bonus

[dokumen tp2]: https://docs.google.com/document/d/1qJxGpnxWUHWyeRbyOXP0rkGheilOUGk8r9jvJxRRbOk/edit?usp=sharing
[root-readme]: ../README.md#memulai
[testcases]: assignment3/testcases
