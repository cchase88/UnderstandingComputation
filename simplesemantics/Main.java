package simplesemantics;

import simplesemantics.ops.*;
import simplesemantics.types.*;
import simplesemantics.types.Number;

public class Main {
	
	public static void main(String[] args){


		Expression whileexp = new While(
				// condition
				new LessThan(new Variable("x"), new Number(5)),
				// body
				new Assignment(new Variable("x"), new Add(new Variable("x"), new Number(1))));
		
		Environment env1 = new Environment();
		env1.put("x", new Number(0));
		
		//whileexp.evaluate(env1);
		
		System.out.println(env1.toString());

		VirtualMachine vm = new VirtualMachine(whileexp, env1);
		vm.run();

		
		
	}

}
