package SimpleSemantics.Types;

import SimpleSemantics.Environment;

public class Sequence implements Expression{
	
	private Expression first;
	private Expression second;
	
	public Sequence(Expression first, Expression second){
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean isReducible() {
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		if(first.isReducible()){
			return new Sequence(first.reduce(env), second);
		}		
		else {
			return second;
		}
	}
	
	public String toString(){
		return String.format("%s; %s", first, second);
	}

	@Override
	public Expression evaluate(Environment env) {
		first.evaluate(env);
		return second.evaluate(env);
	}
}
