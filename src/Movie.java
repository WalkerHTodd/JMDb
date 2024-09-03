
public class Movie {

    private String title;
    private int year;
    private String director;
    private String imageLink;
    private Actor[] actorList;
    private String imDbRating;
    // Might not be able to do it
    private String movieRating;
    private String id;
    private String plot;
    private String runTime;
    private String awards;
    private String genres;
    private String countries;
    private String languages;

    public Movie(String title, String director, String id, String poster,
            Actor[] actorList, String imDbRating, String movieRating,
            String year, String plot, String runTime, String awards,
            String genres, String countries, String languages) {
        this.title = title;
        this.id = id;
        this.imageLink = poster;
        this.actorList = actorList;
        if (runTime != "null") {
            this.runTime = runTime;

        } else {
            this.runTime = "N/A";
        }
        
        if (director != "") {
            this.director = director;

        } else {
            this.director = "N/A";
        }
        
        if (awards != "") {
            this.awards = awards;
        } else {
            this.awards = "No Awards";
        }
        this.genres = genres;
        this.countries = countries;
        this.languages = languages;

        if (movieRating != "null") {
            this.imDbRating = imDbRating;

        } else {
            this.imDbRating = "No IMDB Rating";
        }

        if (movieRating != "null") {
            this.movieRating = movieRating;

        } else {
            this.movieRating = "No Content Rating";
        }
        this.plot = plot;

        if (year != "null" && !year.isEmpty()) {
            try {
                if (year.contains("(")) {
                    this.year = Integer.parseUnsignedInt(year.substring(
                            year.indexOf("(") + 1, year.indexOf(")")));

                } else {
                    this.year = Integer.parseUnsignedInt(year.substring(0, 4));
                }
            } catch (NumberFormatException ex) {
                this.year = 0;
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getPoster() {
        return imageLink;
    }

    public String getPlot() {
        return plot;
    }

    public Actor[] getActorList() {
        return actorList;
    }

    public String getIMDBRating() {
        return imDbRating;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getID() {
        return id;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public String getAwards() {
        return awards;
    }

    public String getCountries() {
        return countries;
    }

    public String getLanguages() {
        return languages;
    }
}
