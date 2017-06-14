package simplesemantics.ops;

import simplesemantics.Environment;
import simplesemantics.types.Bool;
import simplesemantics.types.DoNothing;
import simplesemantics.types.Expression;

public class If implements Expression{

	private Expression condition;
	private Expression consequence;
	private Expression alternative;
	
	
	public If(Expression condition, Expression consequence, Expression alternative){
		this.condition = condition;
		this.consequence = consequence;
		this.alternative = alternative;
	}
	
	@Override
	public boolean isReducible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		if(condition.isReducible()){
			return new If(condition.reduce(env), consequence, alternative);
		}
		else {
			if(condition instanceof Bool && ((Bool)condition).value() == true){
				return consequence;
			}
			else if(condition instanceof Bool && ((Bool)condition).value() == false){
				return alternative;
			}
		}
		
		throw new RuntimeException("If condition reduced to invalid type.");
	}
	
	public String toString(){
		return String.format("if(%s) { %s } else { %s }", condition, consequence, alternative); 
	}

	@Override
	public Expression evaluate(Environment env) {
		if( ((Bool)condition).value() ){
			return consequence.evaluate(env);
		}
		else {
			return alternative.evaluate(env);
		}
	}

}
