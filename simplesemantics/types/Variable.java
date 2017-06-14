package simplesemantics.types;

import simplesemantics.Environment;

public class Variable implements Expression{

	private String name;
	
	public Variable(String name){
		this.name = name;
	}

	@Override
	public boolean isReducible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		return env.get(name);
	}
	
	public String toString(){
		return name;
	}

	@Override
	public Expression evaluate(Environment env) {
		return env.get(name);
	}
	
	
}
