package SimpleSemantics.Types;

import SimpleSemantics.Environment;

public class Bool extends Value<Boolean>{

	
	public Bool(Boolean bool){
		super(bool);
	}
	
	public Boolean value(){
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
