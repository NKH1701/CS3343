package Scheduling;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfitMaximizationSchedule extends Schedule {
	
	public ProfitMaximizationSchedule(ArrayList<Movie> movies) {
		super("Profit Maximization Scheduling", movies);
	}
	
	
	public void scheduling() {
		ArrayList<Movie> movies = getMovies();
		Collections.sort(movies);
		
		Movie topMovie = movies.get(0);
		scheduleTopMovie(topMovie, new Theater("1"));
		
		Movie secondTopMovie = movies.get(1);
		scheduleTopMovie(secondTopMovie, new Theater("2"));
		
		
		
		Theater theater3 = new Theater("3");
	    Theater theater4 = new Theater("4");
	    
		
	    availableTheaters.put(theater3, 11 * 60);
	    availableTheaters.put(theater4, 11 * 60);
	    
	    int i = 2;
	    
        while(checkAvailableSlots(movies)) {
            Movie movie = movies.get(i);
            
            Theater nextAvailableTheater = findNextAvailableTheater();
            scheduleMovie(movie, nextAvailableTheater);
            
            i++;
            if(i == movies.size()) {
            	i = 2;
            }       	           
        }	
	}
	
	
	private void scheduleTopMovie(Movie movie, Theater theater) {
		int availableTime = (24 - 11) * 60;  // Total minutes available in a day
	    int startTime = 11 * 60;  // Start time in minutes from midnight
	    
	    while (availableTime  >= movie.getDuration()) {
	    	int endTime = startTime + movie.getDuration();
	    	
	    	 String formattedStartTime = convertMinutesToTimeString(startTime);
	         String formattedEndTime = convertMinutesToTimeString(endTime);
	         
	         ScheduleSlot slot = new ScheduleSlot(movie, formattedStartTime, formattedEndTime, theater);
	         addScheduleSlots(slot);
	         
	         startTime = endTime + getBufferTime(); 
	         availableTime -= (movie.getDuration() + getBufferTime());
	    }
	}
}
