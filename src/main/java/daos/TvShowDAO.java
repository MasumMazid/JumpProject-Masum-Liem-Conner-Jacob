package daos;

import java.util.List;

public interface TvShowDAO {
    public List<TvShow> getAllTvShows();
    public TvShow getTvShowById(int id);
    public TvShow getTvShowByName(String name);
}
