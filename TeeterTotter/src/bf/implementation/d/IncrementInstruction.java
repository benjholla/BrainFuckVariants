package bf.implementation.d;

public class IncrementInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '+'){
			byte incrementValue = interpreter.memory.remove(interpreter.mp);
			interpreter.memory.add(interpreter.mp, ++incrementValue);
		}
	}
}
