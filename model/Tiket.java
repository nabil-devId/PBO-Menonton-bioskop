package model;

public class Tiket {
    private String idTiket;
    private Long harga;
    private Jadwal jadwal;

    public Tiket(String idTiket, Long harga, Jadwal jadwal) {
        this.idTiket = idTiket;
        this.harga = harga;
        this.jadwal = jadwal;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }
}
