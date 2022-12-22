package enumList;

import model.Film;
import model.Kategori;

import java.util.List;
import java.util.stream.Collectors;

public enum FilmEnum {
    AVATAR2("1X","Avatar 2", List.of(KategoriEnum.ACTION, KategoriEnum.SCIFI, KategoriEnum.FANTASY)),
    WAKANDA_FOREVER("2X","Black Panther: Wakanda Forever", List.of(KategoriEnum.ACTION, KategoriEnum.SCIFI, KategoriEnum.FANTASY, KategoriEnum.DRAMA)),
    FROZEN2("3X","Frozen 2", List.of(KategoriEnum.ACTION, KategoriEnum.SCIFI));

    private final Film film;
    FilmEnum(String idFilm, String nameFilm, List<KategoriEnum> kategoriEnum) {
        List<Kategori> kategoris = kategoriEnum.stream().map(kategori -> {
            switch (kategori) {
                case DRAMA:
                    return new Kategori("1", "Drama");
                case SCIFI:
                    return new Kategori("2", "Sci-Fi");
                case ACTION:
                    return new Kategori("3", "Action");
                case FANTASY:
                    return new Kategori("4", "Fantasy");
                case THRILLER:
                    return new Kategori("5", "Thriller");
                case ADVENTURE:
                    return new Kategori("6", "Adventure");
            }
            return new Kategori();
        }).collect(Collectors.toList());

        film = new Film(idFilm, nameFilm, kategoris);
    }

    public Film getFilm() {
        return this.film;
    }
}
