package bf.implementation.d;

public class BeginLoopInstruction implements Instruction {
	@Override
	public void execute(BFInterpreterD interpreter, char instruction) {
		if(instruction == '['){
			if (interpreter.memory.get(interpreter.mp) == 0) {
				int depth = 0;
				while (true) {
					interpreter.ip++;
					if (interpreter.program.charAt(interpreter.ip) == '[') {
						depth++;
						continue;
					} else if (interpreter.program.charAt(interpreter.ip) == ']') {
						if (depth == 0) {
							break;
						} else if (depth > 0) {
							depth--;
							continue;
						}
					}
				}
			}
		}
	}
}
