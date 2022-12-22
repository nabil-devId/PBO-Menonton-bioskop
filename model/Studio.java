package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Studio {
    private String idStudio;
    private String namaStudio;
    private List<Kursi> kursiList;
    private List<Kursi> availableKursi;
    private List<Kursi> bookedKursi = new ArrayList<>();

    public Studio() {
    }

    public Studio(String idStudio, String namaStudio, List<Kursi> kursiList) {
        this.idStudio = idStudio;
        this.namaStudio = namaStudio;
        this.kursiList = kursiList;
        this.availableKursi = kursiList;
    }

    public Boolean bookedKursi(String noKursi) {
        try {
            Kursi kursi = availableKursi.get(Integer.parseInt(noKursi) - 1);
            availableKursi = availableKursi.stream().filter(chair -> !Objects.equals(chair.getIdKursi(), kursi.getIdKursi())).collect(Collectors.toList());
            bookedKursi.add(kursi);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Kursi> getBookedKursi() {
        return bookedKursi;
    }

    public List<Kursi> getAvailableKursi() {
        return availableKursi;
    }

    public String getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(String idStudio) {
        this.idStudio = idStudio;
    }

    public String getNamaStudio() {
        return namaStudio;
    }

    public void setNamaStudio(String namaStudio) {
        this.namaStudio = namaStudio;
    }

    public List<Kursi> getKursiList() {
        return kursiList;
    }

    public void setKursiList(List<Kursi> kursiList) {
        this.kursiList = kursiList;
    }
}
