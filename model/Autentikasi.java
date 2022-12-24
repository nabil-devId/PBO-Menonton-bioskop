package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Autentikasi {
    Pelanggan pelanggan;
    List<Pelanggan> pelangganRegistered = new ArrayList<>();


    public Autentikasi(Pelanggan pelanggan, List<Pelanggan> pelangganRegistered) {
        this.pelanggan = pelanggan;
        this.pelangganRegistered = pelangganRegistered;
    }

    public Autentikasi() {
        pelangganRegistered.add(new Pelanggan("x123", "081111111", "tes1233@gmail.com", "tes", "tes123"));
    }

    public Boolean autentikasiPelanggan(String email, String kataSandi) {
        Optional<Pelanggan> pelanggan = pelangganRegistered.stream().filter(plg -> plg.getEmail().equals(email) && plg.getKataSandi().equals(kataSandi)).findFirst();
        if (pelanggan.isPresent()) {
            this.pelanggan = pelanggan.get();
            return true;
        }
        return false;
    }

    public Boolean registrasiPelanggan(Pelanggan newPelanggan) {
        Boolean userAvailable = pelangganRegistered.stream().noneMatch(pelanggan -> pelanggan.getEmail().equals(newPelanggan.getEmail()));
        if (Boolean.TRUE.equals(userAvailable)) {
            newPelanggan.setIdPelanggan(Integer.toString((pelangganRegistered.size() + 1)));
            pelangganRegistered.add(newPelanggan);
            System.out.println("Berhasil mendaftar, silahkan masuk.");
            return true;
        } else {
            System.out.println("Email sudah terdaftar");
        }
        return false;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public List<Pelanggan> getPelangganRegistered() {
        return pelangganRegistered;
    }

    public void setPelangganRegistered(List<Pelanggan> pelangganRegistered) {
        this.pelangganRegistered = pelangganRegistered;
    }
}
