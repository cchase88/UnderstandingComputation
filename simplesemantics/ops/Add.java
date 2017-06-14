package simplesemantics.ops;

import simplesemantics.Environment;
import simplesemantics.types.Expression;
import simplesemantics.types.Number;
import simplesemantics.types.Value;

public class Add implements Expression{

	private Expression left, right;
	
	public Add(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean isReducible() {
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		if(left.isReducible()){
			return new Add(left.reduce(env), right);
		}
		else if(right.isReducible()){
			return new Add(left, right.reduce(env));
		}
		else {
			
			Number l = (Number)left;
			Number r = (Number)right;
			
			return new Number(l.value() + r.value());
		}
	}
	
	public String toString(){
		return String.format("%s + %s", left, right);
	}

	@Override
	public Expression evaluate(Environment env) {
		Number l = (Number)left.evaluate(env);
		Number r = (Number) right.evaluate(env);
		return new Number(l.value() + r.value());
	}

}
