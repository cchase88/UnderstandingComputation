package SimpleSemantics.Ops;

import SimpleSemantics.Environment;
import SimpleSemantics.Types.Expression;
import SimpleSemantics.Types.Number;

public class Multiply implements Expression{
	
	private Expression left, right;
	
	public Multiply(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isReducible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		if(left.isReducible()){
			return new Multiply(left.reduce(env), right);
		}
		else if(right.isReducible()){
			return new Multiply(left, right.reduce(env));
		}
		else {
			Number l = (Number)left;
			Number r = (Number)right;
			return new Number(l.value() * r.value());
		}
	}
	
	public String toString(){
		return String.format("%s * %s", left, right);
	}

	@Override
	public Expression evaluate(Environment env) {
		Number l = (Number)left.evaluate(env);
		Number r = (Number) right.evaluate(env);
		return new Number(l.value() * r.value());
	}
	
	

}
