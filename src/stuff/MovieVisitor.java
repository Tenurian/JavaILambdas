package stuff;
@FunctionalInterface
public interface MovieVisitor {
	public void visit(Movie movie);
}
