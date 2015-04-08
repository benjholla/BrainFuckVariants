package bf.implementation.d;
import java.util.ArrayList;
import java.util.List;

/**
 * A Brainfuck Interpreter implementation using forward and reverse seek 
 * operations to implementing looping.  This implementation is written with 
 * and observer pattern to replicate event based programming.
 * 
 * Interpreter grammar from: http://en.wikipedia.org/wiki/Brainfuck
 * 
 * Assumptions: 
 * 1) The tape grows infinitely to the right
 * 2) The tape point resets to zero if moved past the leftmost cell
 * 3) A read cannot be made on input that does not exist
 */
public class BFInterpreterD {
	
	public static String execute(String program, String input) {
        BFInterpreterD interpreter = new BFInterpreterD();
        interpreter.addListener(new IncrementInstruction());
        interpreter.addListener(new DecrementInstruction());
        interpreter.addListener(new MoveLeftInstruction());
        interpreter.addListener(new MoveRightInstruction());
        interpreter.addListener(new InputInstruction());
        interpreter.addListener(new OutputInstruction());
        interpreter.addListener(new BeginLoopInstruction());
        interpreter.addListener(new EndLoopInstruction());

        return interpreter.run(program, input);
    }
	
    private List<Instruction> instructions = new ArrayList<Instruction>();
    
 	public ArrayList<Byte> memory = new ArrayList<Byte>();
 	public int mp = 0;
 	public int ip = 0;
 	public String program = "";
 	public String input = "";
 	public String output = "";

    public void addListener(Instruction instruction) {
    	instructions.add(instruction);
    }

    public String run(String program, String input) {
    	
    	// initialize the program
    	this.program = program;
    	
    	// initialize the input
    	this.input = input;
    	
    	// initialize the tape to 1 cell with value 0
		// memory is unbounded in this implementation
		memory = new ArrayList<Byte>();
		memory.add((byte)0x00);
		
		// initialize the memory pointer (index into memory)
		mp = 0;
		
		// initialize the instruction pointer (index into program)
		ip = 0;
		
		// using a string as an output stream
		output = "";
    	
    	// notify the proper instruction listener
		do {
	        for (Instruction instruction : instructions){
	        	instruction.execute(this, program.charAt(ip));
	        }	 
        } while (++ip < program.length());
        
        return output;
    }
}
