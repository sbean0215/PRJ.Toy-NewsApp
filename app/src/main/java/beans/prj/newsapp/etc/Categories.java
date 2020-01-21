package beans.prj.newsapp.etc;

public enum Categories {

    BUSINESS("business"), ENTERTAINMENT("entertainment")
    , HEALTH("health"), SCIENCE("science")
    , SPORTS("sports"), TECHNOLOGY("technology");

    final private String title;

    private Categories(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
