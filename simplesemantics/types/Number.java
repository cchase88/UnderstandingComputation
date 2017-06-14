package SimpleSemantics.Types;

import SimpleSemantics.Environment;

public class Number extends Value<Integer>{

	
	public Number(Integer value){
		super(value);
	}
	
	public Integer value(){
		return this.value;
	}
	
	
	public String toString(){
		return value.toString();
	}

	@Override
	public Expression evaluate(Environment env) {
		return this;
	}
	
	public String toRuby(){
		return String.format("-> { %s }", this);
	}

}
