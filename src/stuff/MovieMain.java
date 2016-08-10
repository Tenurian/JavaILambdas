package stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
		/*stream | intermediate | terminal*/
//		List<Movie> moviesList = Arrays.asList(movies);
//		moviesList.stream().forEach(  (m) -> System.out.println(m.getTitle())  );
//		Arrays.stream(movies).forEach(  (m) -> System.out.println(m.getTitle())  );
		/**===Example of a Pipeline====**/
//		long count = 
		/* C# equivalent of Optional<T> is "T? varName" */
//		String titles = 
		Stream.of(
				new Movie("Raiders of the Lost Ark", 1981, 4.5f, "Adventure"),
				new Movie("The Shining", 1984, 4f, "Horror"),
				new Movie("Lion King", 1996, 4f, "Family"),
				new Movie("Batman and Robin", 1998, 1f, "Action")
				)											//stream
//		.filter( (m) -> m.getYear() > 1983 )				//1st filter
//		.filter( (m) -> m.getYear() < 1998 )				//2nd filter
		.sorted( (m1, m2) -> m2.getYear()-m1.getYear() )	//sorting filter
//		.limit(1)											//limiting filter
//		.skip(1)											//skip n values and return results
		/*  movie ->  String */
		
		.map( (m) -> m.getStars() )							//convert the type from T -> Q
		.distinct()											//get unique objects after filtering and sorting
		.forEach( (t) -> System.out.println(t) );			//terminal that does expression
//		.count();											//terminal that returns count of items
//		.findFirst();										//terminal that gets the first item in the stream,
															//usually follows a sorted filter
//		.findAny();
//		.reduce( "", (s1, s2) -> s1 + " | " + s2 ); //s1 = s1 + " | " + s2, repeat until empty
//		System.out.println(titles);
//		System.out.println(title.isPresent()?title.get():"");
		
		
		
		
		
//		MovieList allMovies = new MovieList(Arrays.asList(movies));
//		MovieList moviesBefore = new MovieList(getMoviesByLambda((m) -> (m.getYear() < 1991), allMovies));
//		MovieList moviesBeforeAndAfter = new MovieList(getMoviesByLambda((m) -> (m.getYear() > 1983), moviesBefore));
//		
//		for(Movie m : moviesBeforeAndAfter){
//			System.out.println(m.getTitle() + " ("+m.getYear()+")");
//		}
		
		
		
		
		
		
		
		
		
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
