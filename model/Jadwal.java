package model;

import java.time.LocalDateTime;

public class Jadwal {
    private String idJadwal;
    private LocalDateTime jamMulai;
    private LocalDateTime jamBerakhir;
    private LocalDateTime tanggal;
    private Film film;
    private Studio studio;

    public Jadwal(String idJadwal, LocalDateTime jamMulai, LocalDateTime jamBerakhir, LocalDateTime tanggal, Film film, Studio studio) {
        this.idJadwal = idJadwal;
        this.jamMulai = jamMulai;
        this.jamBerakhir = jamBerakhir;
        this.tanggal = tanggal;
        this.film = film;
        this.studio = studio;
    }

    public Jadwal() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public LocalDateTime getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(LocalDateTime jamMulai) {
        this.jamMulai = jamMulai;
    }

    public LocalDateTime getJamBerakhir() {
        return jamBerakhir;
    }

    public void setJamBerakhir(LocalDateTime jamBerakhir) {
        this.jamBerakhir = jamBerakhir;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
