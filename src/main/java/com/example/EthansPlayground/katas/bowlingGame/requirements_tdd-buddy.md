# Requirements
1. Calculate the score for a game of ten-pin bowling. 
2. Handle all valid bowling scenarios:
   - Regular frames (sum of pins knocked down)
   - Spares (10 pins in two rolls, bonus is next roll)
   - Strikes (10 pins in one roll, bonus is next two rolls)
   - 10th frame special cases (up to three rolls)

3. Validate input:
  Number of pins must be between 0 and 10
  Sum of pins in a frame (except last) must not exceed 10
  Proper number of rolls based on game progress
  
## Test Cases
| Scenario         | Rolls                                                   | Score | Notes                |
|------------------|---------------------------------------------------------|-------|----------------------|
| All Gutter Balls | 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0	       | 0     | No pins knocked down | 
| All Ones	        | 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1	       | 20    | One pin per roll     | 
| One Spare        | 5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0	       | 16    | Spare + bonus        | 
| One Strike       | 10, 3,4, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0	        | 24    | Strike + bonus       | 
| Perfect Game     | 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10,10	           | 300	  | All strikes          | 
| All Spares       | 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5, 5,5,5 | 150   | 	All spares          |

## Edge Cases to Consider
- Invalid number of pins (>10 or <0)
- Invalid frame totals (>10 in a fr   ame)
- Wrong number of rolls for the game state
- Invalid bonus rolls in 10th frame
- Empty or null input

## Tips
- Start with the simplest case (all zeros)
- Add support for regular frames first
- Then add spares, then strikes
- Handle the 10th frame as a special case
- Consider using a Frame class to encapsulate frame logic

## Reference Walkthrough
Full C#, TypeScript, and Python implementations live at
[tddbuddy-reference-katas/bowling-game](https://github.com/Kode-Rex/tddbuddy-reference-katas/tree/main/bowling-game) — 
the same six scenarios across all three languages, walked commit-by-commit through the TDD cycle.

* C# (.NET 8, xUnit, FluentAssertions) — [walkthrough](https://github.com/Kode-Rex/tddbuddy-reference-katas/blob/main/bowling-game/csharp/WALKTHROUGH.md)
* TypeScript (Node 20, Vitest, strict types) — [walkthrough](https://github.com/Kode-Rex/tddbuddy-reference-katas/blob/main/bowling-game/typescript/WALKTHROUGH.md)
* Python (3.11, pytest) — [walkthrough](https://github.com/Kode-Rex/tddbuddy-reference-katas/blob/main/bowling-game/python/WALKTHROUGH.md)

This is a Pedagogy mode kata — the walkthroughs step through the TDD cycle commit-by-commit. Watch the gear shift 
from low (fake-it, sum) to middle once the scoring loop’s two-mode index (frame vs roll cursor) lands. The teaching
point is the class that does not get written: two `reflect —` commits mark the moments the author was tempted to 
extract a `Frame` type and chose not to — the Frame concept lives in the `rollIndex += 1` vs `rollIndex += 2` advance, 
not in a class. See the repo’s [Gears](https://github.com/Kode-Rex/tddbuddy-reference-katas#gears--bridging-tdd-and-bdd)
section for why resisting a premature abstraction is itself a TDD skill.

### Source
These requirements were taken from [TDD Buddy](https://tddbuddy.com/katas/bowling-game/)