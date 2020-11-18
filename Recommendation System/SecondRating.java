
/**
 * Write a description of SecondRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class SecondRating {
     private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRating() {

        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRating(String moviefile, String loadRaters){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(loadRaters);
    }
    
    public int getMovieSize(){
        return myMovies.size();
    
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    private double getAverageByID(String id,int minimalRaters){
        double average =0;
        double total=0;
        int countRaters= 0;
        for(Rater rater:myRaters){
            if(rater.hasRating(id)){
                countRaters++;
                total = total + rater.getRating(id);
            }
        }
        
        if(countRaters >= minimalRaters){
            average = total/countRaters;
        }
        return average;
        
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgRatingList = new ArrayList<Rating>();
        for(Movie movie:myMovies){
            String id = movie.getID();
            double avg = getAverageByID(id,minimalRaters);
            if(avg>0.0){
                Rating currRating = new Rating(id,avg);
                avgRatingList.add(currRating);
            }    
        }
        return avgRatingList;
    }
    
    public String getTitle(String id){
        String title= "";
        for(Movie movie:myMovies){
            if(movie.getID().equals(id)){
                title = movie.getTitle();
                break;
            }
        }
        if(title == ""){
            return "This ID never existed!";
        }
        
        else{
            return id;
        }
    }
    
    public String getID(String title){
        String id ="";
        for(Movie movie:myMovies){
            if(movie.getTitle().equals(title)){
                id = movie.getID();
                break;
            }
        }
        
        if(id ==""){
            return "Not Found";
        }
        else{
            return id;
        }
        
    }
    

}
