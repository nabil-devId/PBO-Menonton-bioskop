package model;

public class Kursi {
    private String idKursi;
    private Integer noKursi;

    public Kursi(String idKursi, Integer noKursi) {
        this.idKursi = idKursi;
        this.noKursi = noKursi;
    }


    public String getIdKursi() {
        return idKursi;
    }

    public void setIdKursi(String idKursi) {
        this.idKursi = idKursi;
    }

    public Integer getNoKursi() {
        return noKursi;
    }

    public void setNoKursi(Integer noKursi) {
        this.noKursi = noKursi;
    }
}
