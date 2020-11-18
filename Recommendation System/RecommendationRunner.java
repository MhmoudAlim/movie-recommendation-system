
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (Mahmoud) 
 * @version (25/9/2020)
 */
import java.util.*;

public class RecommendationRunner implements Recommender {
    public ArrayList<String> getItemsToRate(){
        ArrayList<String> moviesToRate = new ArrayList<String>();

        String [] movies ={"1091191","1535108","1763303","1600196",
                "72684","1334553","1291584","1205489", "32143",
                "54215","215750","281358","840361","1498569", "1702439" };
        for(int i=0;i<14;i++){
            moviesToRate.add(movies[i]);
        }
        return moviesToRate;
    }

    public void printRecommendationsFor(String webRaterID){
        FourthRatings fr = new FourthRatings();
        int numSimilarRaters = 5;
        int minimalRaters = 3 ;

        ArrayList<Rating> recList = fr.getSimilarRatings(webRaterID,numSimilarRaters,minimalRaters);
       
            printUpperPart();
            int i=0;
            for(Rating r: recList){
                i++;
                if((i+1)%2 == 0){
                    System.out.println("<tr class=\"even_rows\"><td>" + i + "</td>");
                }
                else{
                    System.out.println("<tr class=\"odd_rows\"><td>" + i + "</td>");
                }

                String URL = Moviedatabase.getPoster(r.getItem());
                String title = Moviedatabase.getTitle(r.getItem());
                String country = Moviedatabase.getCountry(r.getItem());
                String director = Moviedatabase.getDirector(r.getItem());
                String genre = Moviedatabase.getGenres(r.getItem());
                int year = Moviedatabase.getYear(r.getItem());
                int minutes = Moviedatabase.getMinutes(r.getItem());

                System.out.println("<td><table><tr><td class = \"pic\">");

                if(URL.length()>3){
                    System.out.println("<img src = \""+URL+"\" target=_blank></td>");
                }

                System.out.println("<td><h3>"+ title+"</h3>");
                System.out.println("<b>by "+ genre+"</b><br>");
                System.out.println(country+"<br>");
                System.out.println(year+"<br>");
                System.out.println(minutes+" minutes</td></tr></table></td></tr>");

            printLowerPart();

        }
    }
    
    private void printUpperPart(){
        System.out.println("<link href=\"https://fonts.googleapis.com/css?family=Inconsolata\" rel=\"stylesheet\"><link href=\"https://fonts.googleapis.com/css?family=Inconsolata\" rel=\"stylesheet\"><div id=\"header\"><h2>Recommended Movies:</h2></div><table class=\"outside_table\"><tr  class=\"table-header\"><th>&nbsp</th><th class=\"movie_title\">Title</th></tr>");
    }

    private void printCSS(){
        System.out.println("<style>* {margin: 0;padding: 0;}img{height: 100px;margin:10px;}#header{background-color: ##f7e6ff;margin: 5px ;height: 100px;}td{padding : 5px;}tr{padding-bottom: 5px;}.table-header{background-color: ##ff99ff;}</style>");
    }

    private void printLowerPart(){
        System.out.println("</table>");
    }

}


