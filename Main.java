import enumList.FilmEnum;
import model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pelanggan pelanggan;
        Autentikasi autentikasi = new Autentikasi();
        final List<Kursi> kursiList = List.of(
                new Kursi("1", 1),
                new Kursi("2", 2),
                new Kursi("3", 3),
                new Kursi("4", 4),
                new Kursi("5", 5)
        );
        final List<Studio> studioList = List.of(
                new Studio("1", "Studio 1", kursiList),
                new Studio("2", "Studio 2", kursiList),
                new Studio("3", "Studio 3", kursiList)
        );
        final List<Jadwal> jadwalList = List.of(
                new Jadwal(
                        "1XD",
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        FilmEnum.WAKANDA_FOREVER.getFilm(),
                        studioList.get(1)
                ),
                new Jadwal(
                        "2XD",
                        LocalDateTime.now().plusWeeks(1).plusHours(8),
                        LocalDateTime.now().plusWeeks(1).plusHours(10),
                        LocalDateTime.now().plusWeeks(1),
                        FilmEnum.FROZEN2.getFilm(),
                        studioList.get(2)
                ),
                new Jadwal(
                        "3XD",
                        LocalDateTime.now().plusWeeks(2).plusHours(2),
                        LocalDateTime.now().plusWeeks(2).plusHours(5),
                        LocalDateTime.now().plusWeeks(2),
                        FilmEnum.AVATAR2.getFilm(),
                        studioList.get(2)
                )
        );
        String command = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Pilih Menu : ");
            System.out.println("1. Masuk");
            System.out.println("2. Daftar");
            System.out.println("Untuk keluar, ketik : exit");
            System.out.print("Masukan Piihan : ");

            command = sc.next();
            if (command.equals("1")){

                System.out.print("Masukan email kamu: ");
                String email = sc.next();
                System.out.print("Masukan kata sandi kamu: ");
                String kataSandi = sc.next();
                Boolean hasil = autentikasi.autentikasiPelanggan(email, kataSandi);
                if (Boolean.TRUE.equals(hasil)) {
                    pelanggan = autentikasi.getPelanggan();
                    pelanggan.setJadwalList(jadwalList);
                    do {
                        command = pelanggan.lihatMenu(sc);
                    } while (!command.toLowerCase(Locale.ROOT).equals("exit"));
                    command = "";
                } else {
                    System.out.println("Email atau katasandi salah.");
                }
            } else if (command.equals("2")) {
                Pelanggan newPelanggan = new Pelanggan();
                Boolean registerSuccess;
                do {
                    System.out.print("Masukan nama : ");
                    newPelanggan.setNama(sc.next());
                    System.out.print("Masukan email : ");
                    newPelanggan.setEmail(sc.next());
                    System.out.print("Masukan nomor hp : ");
                    newPelanggan.setNoHp(sc.next());
                    System.out.print("Masukan kata sandi : ");
                    String password = sc.next();
                    newPelanggan.setKataSandi(password);
                    registerSuccess = autentikasi.registrasiPelanggan(newPelanggan);
                } while (Boolean.FALSE.equals(registerSuccess));
            } else if (command.equals("exit")){} else {
                System.out.println("Perintah yang kamu masukan salah");
                System.out.println("===================================");
            }
        }while (!command.toLowerCase(Locale.ROOT).equals("exit"));
    }
}
