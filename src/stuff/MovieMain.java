package stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MovieMain {

	static Movie[] movies = {
			new Movie("Raiders of the Lost Ark", 1981, 4.5f, "Adventure"),
			new Movie("Lion King", 1996, 4, "Family"),
			new Movie("Batman and Robin", 1998, 1f, "Action"),
			new Movie("The Shining", 1984, 4f, "Horror")
	};

	public static void visitMovies(Movie[] movies, MovieVisitor visitor){
		for(int i = 0; i < movies.length; i++){
			visitor.visit(movies[i]);
		}
	}

	public static ArrayList<Movie> getMoviesAfterYear(int year, List<Movie> movies){
		ArrayList<Movie> moviesAfterYear = new ArrayList<Movie>();
		for(Movie movie : movies){
			if(movie.getYear() > year){
				moviesAfterYear.add(movie);
			}
		}
		return moviesAfterYear;
	}

	public static ArrayList<Movie> getMoviesBeforeYear(int year, List<Movie> movies){
		ArrayList<Movie> moviesBeforeYear = new ArrayList<Movie>();
		for(Movie movie : movies){
			if(movie.getYear() < year){
				moviesBeforeYear.add(movie);
			}
		}
		return moviesBeforeYear;
	}
	
	public static ArrayList<Movie> getMoviesByLambda(Predicate<Movie> p, MovieList movies){
		ArrayList<Movie> moviesByLambda = new ArrayList<Movie>();
		for(Movie movie : movies){
			if(p.test(movie)){
				moviesByLambda.add(movie);
			}
		}
		return moviesByLambda;
	}

	public static void main(String[] args) {
		MovieList allMovies = new MovieList(Arrays.asList(movies));
		MovieList moviesBefore = new MovieList(getMoviesByLambda((m) -> (m.getYear() < 1991), allMovies));
		MovieList moviesBeforeAndAfter = new MovieList(getMoviesByLambda((m) -> (m.getYear() > 1983), moviesBefore));
		
		for(Movie m : moviesBeforeAndAfter){
			System.out.println(m.getTitle() + " ("+m.getYear()+")");
		}
		
		
		
		
		
		
		
		//		visitMovies(movies, new PrintTitleAndYear());
		//		System.out.println();
		//		visitMovies(movies, new PrintTitleAndGenre());
		//		System.out.println();
		//
		//		visitMovies(movies, new MovieVisitor(){
		//			@Override
		//			public void visit(Movie movie) {
		//				System.out.println(movie.getTitle() + ", ("+movie.getStars()+")");
		//			}
		//		});
		//		System.out.println();
		//        /*
		//		MovieVisitor visitor = new MovieVisitor(){
		//			@Override
		//			public void visit(Movie movie) {
		//				System.out.println(movie.getTitle() + ", ("+movie.getYear()+")");
		//			}
		//		};
		//		*/
		//
		//		//syntactic sugar
		//		MovieVisitor visitor = (movie) -> {
		//			System.out.println(movie.getTitle() + ", ("+movie.getYear()+")");
		//		};
		//
		//		visitMovies(movies, visitor);
		//		System.out.println();
		//		//methodThatUsesFunctionalInterface(..., token -> {code using token});
		//		visitMovies(movies, (movie) -> System.out.println(movie.getTitle() + ", ("+movie.getYear()+")") );

	}

	public static class PrintTitleAndYear implements MovieVisitor{
		@Override
		public void visit(Movie movie) {
			System.out.println(movie.getTitle() + ", ("+movie.getYear()+")");
		}
	}

	public static class PrintTitleAndGenre implements MovieVisitor{
		@Override
		public void visit(Movie movie) {
			System.out.println(movie.getTitle() + ", ("+movie.getGenre()+")");
		}
	}

}
