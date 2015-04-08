package bf.implementation.d;

public class MoveLeftInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '<'){
			interpreter.mp = (interpreter.mp>0) ? interpreter.mp-1 : 0;
		}
	}
}
