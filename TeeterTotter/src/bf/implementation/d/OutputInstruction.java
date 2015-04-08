package bf.implementation.d;

public class OutputInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '.'){
			// debug and live output stream
			//System.out.print(new String(new byte[] {interpreter.memory.get(interpreter.mp)}));
			
			interpreter.output += new String(new byte[] {interpreter.memory.get(interpreter.mp)});
		}
	}
}
