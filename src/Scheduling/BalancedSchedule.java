package Scheduling;

import java.util.ArrayList;
import java.util.Collections;

public class BalancedSchedule extends Schedule {
	
	public BalancedSchedule(ArrayList<Movie> movies) {
		super("Balanced Scheduling", movies);
	}
	
	public void scheduling() {
		ArrayList<Movie> movies = getMovies();
		
		
		
		Theater theater1 = new Theater("1");
	    Theater theater2 = new Theater("2");
		Theater theater3 = new Theater("3");
	    Theater theater4 = new Theater("4");
	    
	    availableTheaters.put(theater1, 11 * 60);
	    availableTheaters.put(theater2, 11 * 60);
	    availableTheaters.put(theater3, 11 * 60);
	    availableTheaters.put(theater4, 11 * 60);
	    
	    int i = 0;
	    
        while(checkAvailableSlots(movies)) {
            Movie movie = movies.get(i);
            
            Theater nextAvailableTheater = findNextAvailableTheater();
            scheduleMovie(movie, nextAvailableTheater);
            
            i++;
            if(i == movies.size()) {
            	i = 0;
            	break;
            }       	           
        }
        
        Collections.sort(movies);
        
        while(checkAvailableSlots(movies)) {
            Movie movie = movies.get(i);
            
            Theater nextAvailableTheater = findNextAvailableTheater();
            scheduleMovie(movie, nextAvailableTheater);
            
            i++;
            if(i == movies.size()) {
            	i = 0;
            }       	           
        }   
	}
	
}
