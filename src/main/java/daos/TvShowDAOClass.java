

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TvShowDAOClass implements TvShowDAO {
    private Connection conn = ConnectionManager.getConnection();

    public List<TvShow> getAllTvShows() {
        List<TvShow> tvShowList = new ArrayList<TvShow>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM TVShow"
            );

            while(rs.next()) {
                tvShowList.add(new TvShow(
                    rs.getInt("tv_id"),
                    rs.getString("show_name")
                ));
            }

            rs.close();
            stmt.close();
            
            return tvShowList;

        } catch(SQLException e) {

        }

        return tvShowList;
    }

    public TvShow getTvShowById(int id) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM TVShow WHERE tv_id = ?"
            );
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            TvShow show = new TvShow(
                rs.getInt("tv_id"),
                rs.getString("show_name")
            );

            rs.close();
            pstmt.close();

            return show;

        } catch(SQLException e) {

        }


        return null;
    }

    public TvShow getTvShowByName(String name) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM TVShow WHERE show_name = ?"
            );
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            TvShow show = new TvShow(
                rs.getInt("tv_id"),
                rs.getString("show_name")
            );

            rs.close();
            pstmt.close();

            return show;

        } catch(SQLException e) {

        }


        return null;
    }
}