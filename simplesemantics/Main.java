package SimpleSemantics;

import SimpleSemantics.Ops.*;
import SimpleSemantics.Types.Expression;
import SimpleSemantics.Types.Number;
import SimpleSemantics.Types.Sequence;
import SimpleSemantics.Types.Variable;

public class Main {
	
	public static void main(String[] args){


		Expression whileexp = new While(
				// condition
				new LessThan(new Variable("x"), new Number(5)),
				// body
				new Assignment(new Variable("x"), new Add(new Variable("x"), new Number(1))));
		
		Environment env = new Environment();
		env.put("x", new Number(0));
		
		whileexp.evaluate(env);
		
		System.out.println(env.toString());

//		VirtualMachine vm = new VirtualMachine(whileexp, env);
//		vm.run();
//		
		
//		Expression seq = new Sequence(new Assignment(new Variable("age"), new Number(28)),
//									  new Assignment(new Variable("salary"), new Number(105000)));
//		Environment env = new Environment();
//		
//		VirtualMachine vm = new VirtualMachine(seq, env);
//		vm.run();
		
		
//		Expression var = new Variable("x");
//		Environment env = new Environment();
//		env.put("x", new Number(5));

//		Expression assignment = new Assignment(new Variable("age"), new Add(new Number(14), new Number(14)));
//		Environment env = new Environment();
//		
//		VirtualMachine vm = new VirtualMachine(assignment, env);
//		vm.run();		
		

//		Expression ifstatement = 
//				new If(new LessThan(new Number(1), new Number(5)),
//				//then 
//				new Assignment(new Variable("age"), new Number(28)),
//				// else
//				new Number(0));
//		Environment env = new Environment();
//		
//		VirtualMachine vm = new VirtualMachine(ifstatement, env);
//		vm.run();
//		
//		Expression add = new Add(new Number(1), new Number(2));
//		Environment env1 = new Environment();
//		
//		VirtualMachine vm1 = new VirtualMachine(add, env1);
//		vm1.run();
//		
//		Expression mult = new Multiply(new Number(2), new Number(4));
//		Environment env2 = new Environment();
//		
//		VirtualMachine vm2 = new VirtualMachine(mult, env1);
//		vm2.run();
		
//		Expression mult2 = new Multiply(new Add(new Number(5), new Number(11)), new Number(4));
//		Environment env3 = new Environment();
//		
//		VirtualMachine vm3 = new VirtualMachine(mult2, env3);
//		vm3.run();
		
		
//		Expression lessthan = new LessThan(new Add(new Number(5), new Number(11)), new Number(25));
//		Environment env4 = new Environment();
//		
//		VirtualMachine vm4 = new VirtualMachine(lessthan, env4);
//		vm4.run();
		
//		Expression gt = new GreaterThan(new Add(new Number(5), new Number(11)), new Number(25));
//		Environment env5 = new Environment();
//		
//		VirtualMachine vm5 = new VirtualMachine(gt, env5);
//		vm5.run();	
		
		
	}

}
