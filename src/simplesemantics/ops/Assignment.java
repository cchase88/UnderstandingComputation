package simplesemantics.ops;

import simplesemantics.Environment;
import simplesemantics.types.DoNothing;
import simplesemantics.types.Expression;
import simplesemantics.types.Value;
import simplesemantics.types.Variable;

public class Assignment implements Expression{

	private Variable var;
	private Expression exp;
	
	public Assignment(Variable var, Expression exp){
		this.var = var;
		this.exp = exp;
	}
	
	@Override
	public boolean isReducible() {
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		//TODO Instead of reducing the expression right away, can we store it as a variable?
		// Lazy evaluation?
		if(exp.isReducible()){
			return new Assignment(var, exp.reduce(env));
		}
		else {
			env.put(var.toString(), (Value<?>)exp);
			return new DoNothing();
		}
		
	}
	
	public String toString(){
		return var.toString() + " := " + exp.toString();
	}

	@Override
	public Expression evaluate(Environment env) {
		env.put(var.toString(), (Value<?>)exp.evaluate(env));
		return new DoNothing();
	}
	
	

}
