package model;

import java.util.List;

public class Film {
    private String idFilm;
    private String judul;
    private List<Kategori> kategori;

    public Film(String idFilm, String judul, List<Kategori> kategori) {
        this.idFilm = idFilm;
        this.judul = judul;
        this.kategori = kategori;

    }

    public Film() {
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public List<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(List<Kategori> kategori) {
        this.kategori = kategori;
    }
}
