package SimpleSemantics.Ops;

import SimpleSemantics.Environment;
import SimpleSemantics.Types.Bool;
import SimpleSemantics.Types.DoNothing;
import SimpleSemantics.Types.Expression;
import SimpleSemantics.Types.Sequence;

public class While implements Expression {

	private Expression condition;
	private Expression body;
	
	public While(Expression condition, Expression body){
		this.condition = condition;
		this.body = body;
	}
		
	@Override
	public boolean isReducible() {
		return true;
	}

	@Override
	public Expression reduce(Environment env) {
		return new If(condition.reduce(env), new Sequence(body, this), new DoNothing());
	}
	
	public String toString(){
		return String.format("while(%s) { %s }", condition, body);
	}

	@Override
	public Expression evaluate(Environment env) {
		Bool c = (Bool)condition.evaluate(env);
		if(c.value()){
			body.evaluate(env);
			return evaluate(env);
		}
		else {
			return new DoNothing();
		}
	}

}
