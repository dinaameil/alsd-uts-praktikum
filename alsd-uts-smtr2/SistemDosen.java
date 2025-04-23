import java.util.Scanner;

public class SistemDosen {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Dosen[] daftarDosen = {
            new Dosen("0410102090", "Agus Santoso", "agussantoso@polinema.ac.id", 2010, "Teknik Informatika"),
            new Dosen("0410102078", "Budi Hartono", "budihartono@polinema.ac.id", 2012, "Sistem Informasi"),
            new Dosen("0410102110", "Citra Dewi", "citradewi@polinema.ac.id", 2015, "Teknik Informatika"),
            new Dosen("0410102094", "Dedi Prasetyo", "dediprasetyo@polinema.ac.id", 2011, "Teknik Komputer")
        };

        int pilihan;
        do {
            System.out.println("\n=== Menu Sistem Pengelolaan Data Dosen ===");
            System.out.println("1. Tampilkan semua data dosen");
            System.out.println("2. Urutkan data dosen berdasarkan NIDN");
            System.out.println("3. Cari dosen berdasarkan nama");
            System.out.println("4. Urutkan data dosen berdasarkan masa kerja");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt(); input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanSemuaDosen(daftarDosen);
                    break;
                case 2:
                    bubbleSortNIDN(daftarDosen);
                    System.out.println("Data dosen berhasil diurutkan berdasarkan NIDN.");
                    tampilkanSemuaDosen(daftarDosen);
                    break;
                case 3:
                    System.out.print("Masukkan nama yang dicari: ");
                    String namaDicari = input.nextLine();
                    cariDosenByNama(daftarDosen, namaDicari);
                    break;
                case 4:
                    selectionSortMasaKerja(daftarDosen);
                    System.out.println("Berikut data dosen berdasarkan masa kerja:");
                    tampilkanSemuaDosen(daftarDosen);
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void tampilkanSemuaDosen(Dosen[] dosenList) {
        for (Dosen d : dosenList) {
            d.tampilkanData();
        }
    }

    static void bubbleSortNIDN(Dosen[] dosenList) {
        for (int i = 0; i < dosenList.length - 1; i++) {
            for (int j = 0; j < dosenList.length - 1 - i; j++) {
                if (dosenList[j].nidn.compareTo(dosenList[j + 1].nidn) > 0) {
                    Dosen temp = dosenList[j];
                    dosenList[j] = dosenList[j + 1];
                    dosenList[j + 1] = temp;
                }
            }
        }
    }

    static void cariDosenByNama(Dosen[] dosenList, String nama) {
        boolean ditemukan = false;
        for (Dosen d : dosenList) {
            if (d.nama.toLowerCase().contains(nama.toLowerCase())) {
                d.tampilkanData();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Dosen dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    static void selectionSortMasaKerja(Dosen[] dosenList) {
        for (int i = 0; i < dosenList.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < dosenList.length; j++) {
                if (dosenList[j].getMasaKerja() > dosenList[maxIdx].getMasaKerja()) {
                    maxIdx = j;
                }
            }
            Dosen temp = dosenList[maxIdx];
            dosenList[maxIdx] = dosenList[i];
            dosenList[i] = temp;
        }
    }
}