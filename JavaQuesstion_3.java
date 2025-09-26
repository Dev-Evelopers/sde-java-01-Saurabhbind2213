import java.util.*;

// IFilm interface
interface IFilm {
    String getTitle();
    String getDirector();
    int getYear();
}

// Film class implementing IFilm
class Film implements IFilm {
    private String title;
    private String director;
    private int year;

    public Film(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " (" + director + ", " + year + ")";
    }
}

// IFilmLibrary interface
interface IFilmLibrary {
    void addFilm(IFilm film);
    IFilm removeFilm(String title);
    List<IFilm> getFilms();
    List<IFilm> searchFilms(String query);
    int getTotalFilmCount();
}

// FilmLibrary class implementing IFilmLibrary
class FilmLibrary implements IFilmLibrary {
    private List<IFilm> films;

    public FilmLibrary() {
        this.films = new ArrayList<>();
    }

    @Override
    public void addFilm(IFilm film) {
        films.add(film);
    }

    @Override
    public IFilm removeFilm(String title) {
        Iterator<IFilm> it = films.iterator();
        while (it.hasNext()) {
            IFilm film = it.next();
            if (film.getTitle().equals(title)) {
                it.remove();
                return film;
            }
        }
        return null;
    }

    @Override
    public List<IFilm> getFilms() {
        return films;
    }

    @Override
    public List<IFilm> searchFilms(String query) {
        List<IFilm> results = new ArrayList<>();
        for (IFilm film : films) {
            if (film.getTitle().contains(query) || film.getDirector().contains(query)) {
                results.add(film);
            }
        }
        return results;
    }

    @Override
    public int getTotalFilmCount() {
        return films.size();
    }
}

// Main class
public class JavaQuesstion_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim()); // number of films
        FilmLibrary library = new FilmLibrary();

        // Add films
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String title = parts[0];
            String director = parts[1];
            int year = Integer.parseInt(parts[2]);
            library.addFilm(new Film(title, director, year));
        }

        String searchQuery = sc.nextLine().trim(); // search string
        String removeTitle = sc.nextLine().trim(); // film to remove
        sc.close();

        // Output
        System.out.println("Total Film Count: " + library.getTotalFilmCount());

        // Search
        List<IFilm> searchResults = library.searchFilms(searchQuery);
        System.out.println("Search Results for " + searchQuery + ":");
        for (IFilm film : searchResults) {
            System.out.println(film);
        }

        // Remove
        IFilm removed = library.removeFilm(removeTitle);
        if (removed != null) {
            System.out.println("Removed Film: " + removed);
        }

        // Show all films
        System.out.println("All Films:");
        for (IFilm film : library.getFilms()) {
            System.out.println(film);
        }
    }
}

