package daos;

import java.util.List;
import models.TvShow;

public interface TvShowDAO {
    public List<TvShow> getAllTvShows();
    public TvShow getTvShowById(int id);
    public TvShow getTvShowByName(String name);
}
