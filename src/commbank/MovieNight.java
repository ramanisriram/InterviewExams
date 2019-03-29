package commbank;

import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
    	ArrayList<Movie> dummyList = (ArrayList<Movie>) movies;
    	boolean result = true;
        for(int i=0; i<dummyList.size(); i++) {
        	result = true;
        	Movie movie1 = dummyList.get(i);
        	Date tem1SDate = null;
        	Date tem1EDate = null;
        	Date tem2SDate = null;
        	Date tem2EDate = null;
        	for(int j=i+1; j<dummyList.size(); j++) {
        		Movie movie2 = dummyList.get(j);
        		int eqCheck = movie1.getEnd().compareTo(movie2.getStart());
	        	if((eqCheck == 0) || movie1.getEnd().before(movie2.getStart())) {
	        		//System.out.println("Yes its before");
	        	} else {
	        		/*System.out.println("i:"+i);
	        		System.out.println("j:"+j);
	        		System.out.println("In else");*/
	        		//check for opposite
	        		int eqCheck2 = movie1.getStart().compareTo(movie2.getEnd());
		        	if((eqCheck2 == 0) || movie1.getStart().after(movie2.getEnd())) {
		        		//System.out.println("Yes its before 2nd time");
		        	} else {
		        		//System.out.println("In last");
		        		result = false;
		        	}
	        	}
        	}
        	if(!result)
        		break;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}