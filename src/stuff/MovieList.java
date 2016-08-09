package stuff;

import java.util.Iterator;
import java.util.List;

public class MovieList  implements Iterable<Movie> {
	private List<Movie> movies;
	public MovieList(List<Movie> movies) {
		this.movies = movies;
	}
	
	@Override
	public Iterator<Movie> iterator() {
		MovieIterator mi = new MovieIterator(movies);
		return mi;
		//return new MovieIterator(movies);
	}
	
	public class MovieIterator implements Iterator<Movie>{
		private List<Movie> movies;
		int index = 0;
		public MovieIterator(List<Movie> movies){
			this.movies = movies;
		}
		
		@Override
		public boolean hasNext() {
			return index < movies.size();
		}

		@Override
		public Movie next() {
			return movies.get(index++);
		}
		
	}
}
