package bf.implementation.d;

public class MoveRightInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '>'){
			interpreter.mp++;
			if(interpreter.mp == interpreter.memory.size()){
				// we have reached the end of the tape, grow by one cell
				interpreter.memory.add((byte)0x00);
			}
		}
	}
}
