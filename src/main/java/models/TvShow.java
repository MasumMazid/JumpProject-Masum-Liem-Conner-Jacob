package models;

public class TvShow {
    private int tvShow_id;
    private String tvShow_name;

    public TvShow(int tvShow_id, String tvShow_name) {
        this.tvShow_id = tvShow_id;
        this.tvShow_name = tvShow_name;
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "tvShow_id='" + tvShow_id + '\'' +
                ", tvShow_name='" + tvShow_name + '\'' +
                '}';
    }

    public int getTvShow_id() {
        return tvShow_id;
    }

    public void setTvShow_id(int tvShow_id) {
        this.tvShow_id = tvShow_id;
    }

    public String getTvShow_name() {
        return tvShow_name;
    }

    public void setTvShow_name(String tvShow_name) {
        this.tvShow_name = tvShow_name;
    }
}