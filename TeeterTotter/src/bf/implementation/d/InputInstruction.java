package bf.implementation.d;

public class InputInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == ','){
			interpreter.memory.remove(interpreter.mp);
			interpreter.memory.add(interpreter.mp, (byte)interpreter.input.charAt(0));
			interpreter.input = interpreter.input.substring(1,interpreter.input.length());
		}
	}
}
