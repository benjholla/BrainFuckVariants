# BrainFuck Variants
A few variants of BrainFuck interpreter implementations.  The source project folder is called "Teeter-Totter" because it came from an era when I thought naming things around playground equipment was somehow cool.

## Implementation Assumptions
All implementations assume the following.

0. The interpreter grammar is defined as described at [http://en.wikipedia.org/wiki/Brainfuck](http://en.wikipedia.org/wiki/Brainfuck)
1. The tape grows infinitely to the right
2. The tape point resets to zero if moved past the leftmost cell
3. A read cannot be made on input that does not exist

## Variants
- Variant A is a traditional implementation using forward and reverse seek to implement looping
- Variant B uses a computed jump table to implement looping
- Variant C uses a stack to track return address jumps to implement looping
- Variant D is a traditional implementation using forward and reverse seek to implement looping, but instructions are interpreted using an observer pattern to replicate event based programming
