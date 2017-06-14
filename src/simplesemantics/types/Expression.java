package simplesemantics.types;

import simplesemantics.Environment;


public interface Expression {

	public boolean isReducible();
	public Expression reduce(Environment env);
	public String toString();
	public Expression evaluate(Environment env);
	
}
