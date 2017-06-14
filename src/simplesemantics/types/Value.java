package simplesemantics.types;

import simplesemantics.Environment;

public abstract class Value<T> implements Expression{

	protected T value;
	
	public Value(T val){
		this.value = val;
	}
	
	public T val(){
		return this.value; 
	}
	
	
	@Override
	public boolean isReducible() {
		return false;
	}

	@Override
	public Expression reduce(Environment env) {
		return this;
	}
	
	

}
