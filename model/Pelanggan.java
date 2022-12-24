package model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pelanggan {
    private String idPelanggan;
    private String noHp;
    private String email;
    private String nama;
    private String kataSandi;
    private List<Tiket> tiketList = new ArrayList<>();
    private List<Jadwal> jadwalList = new ArrayList<>();

    public void setJadwalList(List<Jadwal> jadwalList) {
        this.jadwalList = jadwalList;
    }

    public List<Jadwal> getJadwalList() {
        return jadwalList;
    }

    public Pelanggan() {
    }

    public Pelanggan(String idPelanggan, String noHp, String email, String nama, String kataSandi) {
        this.idPelanggan = idPelanggan;
        this.noHp = noHp;
        this.email = email;
        this.nama = nama;
        this.kataSandi = kataSandi;
    }

    public String lihatMenu(Scanner sc) {
        String command;
        System.out.println("Selamat datang, " + this.getNama() + " : ");
        System.out.println("1. Lihat tiket");
        System.out.println("2. Beli tiket");
        System.out.println("3. Keluar");
        command = sc.next();
        if (command.equals("1")) {
            Integer[] position = {1};
            if (getTiketList().isEmpty()) {
                System.out.println("Anda belum membeli tiket.");
                System.out.println("============================");
            }
            getTiketList().forEach(tiket -> {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String mulai = tiket.getJadwal().getJamMulai().format(dateTimeFormatter);
                String berakhir = tiket.getJadwal().getJamBerakhir().format(dateTimeFormatter);
                String tanggalTayang = tiket.getJadwal().getTanggal().format(dateFormatter);
                String kategori = tiket.getJadwal().getFilm().getKategori().stream().map(Kategori::getNamaKategori).collect(Collectors.joining(", "));
                System.out.println(Arrays.toString(position) + ". " + tiket.getJadwal().getFilm().getJudul() + " ("+kategori+") \r\nJam tayang: " + mulai + " - " + berakhir + "[" + tanggalTayang + "]" +
                        "\r\nStudio: " + tiket.getJadwal().getStudio().getNamaStudio() + ", Kursi: " + tiket.getJadwal().getStudio().getBookedKursi().stream().map(booked -> "["+booked.getNoKursi()+"]").collect(Collectors.joining(",")) );
                System.out.println("===========================================================");
                position[0]++;
            });
        } else if (command.equals("2")) {
            String jadwal;
            do {
                System.out.println("Daftar jadwal :");
                lihatJadwal();
                System.out.println("Untuk kembali, ketik : exit");
                System.out.print("Pilih jadwal :");
                jadwal = sc.next();
                try {
                    if (Integer.parseInt(jadwal) <= jadwalList.size()) {
                        Jadwal jadwalSelected = jadwalList.get(Integer.parseInt(jadwal) - 1);
                        String kursi;
                        do {
                            Integer[] position = {1};
                            System.out.println("Pilih kursi :");
                            jadwalSelected.getStudio().getAvailableKursi().forEach(chair -> {
                                System.out.println(Arrays.toString(position) + ". " + "nomor: " + chair.getNoKursi());
                                position[0]++;
                            });
                            System.out.println(Arrays.toString(position) + ". Kembali");
                            System.out.print("Kursi: ");
                            kursi = sc.next();
                            if (Integer.parseInt(kursi) <= jadwalSelected.getStudio().getAvailableKursi().size()) {
                                if (Boolean.TRUE.equals(jadwalSelected.getStudio().bookedKursi(kursi))) {
                                    if (tiketList.stream().noneMatch(tiket -> tiket.getJadwal().getFilm().getIdFilm().equals(jadwalSelected.getFilm().getIdFilm()))) {
                                        tiketList.add(new Tiket(Integer.toString(tiketList.size() + 1), 20000L, jadwalSelected));
                                    }
                                    System.out.println("Berhasil membeli tiket.");
                                }
                                break;
                            } else if (Integer.parseInt(kursi) <= jadwalSelected.getStudio().getAvailableKursi().size() + 1) {
                                break;
                            }
                            System.out.println("Kamu memasukan input yang salah");
                        } while (!kursi.equals(jadwalSelected.getStudio().getAvailableKursi().size()));
                        break;
                    } else {
                        System.out.println("Anda memasukan pilihan yang salah");
                    }
                } catch (Exception e) {
                    System.out.println("Anda memasukan pilihan yang salah");
                }
            } while (!jadwal.equals("exit"));
        } else if (command.equals("3")) {
            return  "exit";
        } else {
            System.out.println("Perintah yang kamu masukan salah.");
        }
        return command;
    }



    public void lihatJadwal() {
        Integer[] position = {1};
        jadwalList.forEach(jadwal -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String mulai = jadwal.getJamMulai().format(dateTimeFormatter);
            String berakhir = jadwal.getJamBerakhir().format(dateTimeFormatter);
            String tanggalTayang = jadwal.getTanggal().format(dateFormatter);
            String kategori = jadwal.getFilm().getKategori().stream().map(Kategori::getNamaKategori).collect(Collectors.joining(", "));
            System.out.println(Arrays.toString(position) + ". " + jadwal.getFilm().getJudul() + " ("+kategori+"), " + mulai + " - " + berakhir + "[" + tanggalTayang + "]");
            position[0]++;
        });
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public List<Tiket> getTiketList() {
        return tiketList;
    }

    public void setTiketList(List<Tiket> tiketList) {
        this.tiketList = tiketList;
    }
}
