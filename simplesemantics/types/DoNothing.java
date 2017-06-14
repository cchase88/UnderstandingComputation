package SimpleSemantics.Types;

import SimpleSemantics.Environment;

public class DoNothing implements Expression{

	public DoNothing(){}

	@Override
	public boolean isReducible() {
		return false;
	}

	@Override
	public Expression reduce(Environment env) {
		return this;
	}
	
	public String toString(){
		return "DoNothing";
	}

	@Override
	public Expression evaluate(Environment env) {
		return this;
	}
	
	
}
