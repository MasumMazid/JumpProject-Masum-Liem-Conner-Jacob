package daos;

import java.util.List;

public interface TvShowDAO {
    public List<TVShow> getAllTvShows();
    public TVShow getTvShowById(int id);
    public TVShow getTvShowByName(String name);
}
