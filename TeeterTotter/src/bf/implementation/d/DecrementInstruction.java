package bf.implementation.d;

public class DecrementInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '-'){
			byte decrementValue = interpreter.memory.remove(interpreter.mp);
			interpreter.memory.add(interpreter.mp, --decrementValue);
		}
	}
}
