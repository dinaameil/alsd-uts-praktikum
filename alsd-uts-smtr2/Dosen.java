public class Dosen {
    String nidn;
    String nama;
    String email;
    int tahunMasuk;
    String prodi;

    Dosen(String nidn, String nama, String email, int tahunMasuk, String prodi) {
        this.nidn = nidn;
        this.nama = nama;
        this.email = email;
        this.tahunMasuk = tahunMasuk;
        this.prodi = prodi;
    }

    int getMasaKerja() {
        int tahunSekarang = java.time.Year.now().getValue();
        return tahunSekarang - tahunMasuk;
    }

    void tampilkanData() {
        System.out.println("NIDN        : " + nidn);
        System.out.println("Nama        : " + nama);
        System.out.println("Email       : " + email);
        System.out.println("Masa Kerja  : " + getMasaKerja() + " tahun");
        System.out.println("Prodi       : " + prodi);
        System.out.println("---------------------------------------");
    }
}