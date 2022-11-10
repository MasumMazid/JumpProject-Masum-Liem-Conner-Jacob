package models;

public class TvShow {
   private int tvShowId;
   private String name;

   public TvShow(int tvShowId, String name) {
       this.tvShowId = tvShowId;
       this.name = name;
   }

   public int getTvShowID() {
       return this.tvShowId;
   }

   public void setTvShowId(int id) {
       this.tvShowId = id;
   }

   public String getName() {
       return this.name;
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public String toString() {
       return "TvShow [tvShowId=" + tvShowId + ", name=" + name + "]";
   }
}
