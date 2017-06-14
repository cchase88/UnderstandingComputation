package simplesemantics;

import java.util.Map;
import simplesemantics.types.Expression;



public class VirtualMachine {

	
	private Expression expression;
	private Environment environment;
	
	public VirtualMachine(Expression expression, Environment env){
		this.expression = expression;
		this.environment = env;
	}
	
	public void run(){
		while(expression.isReducible()){
			System.out.println("<<" + expression.toString() + ">> , " + environment.toString());
			step();
		}
		System.out.println(expression.toString() + ", " + environment.toString());
	}
	
	private void step(){
		
		Expression reduced = expression.reduce(environment);
		expression = reduced;		
		
	}
	
	
}
