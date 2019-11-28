// Agent sample_agent in project hellojacamo

/* Initial beliefs and rules */

human(left). 
repetition(3).
robotToken("opensesame").


/* Initial goals */

!start.


/* Plans */

+!start : true <- 
	.print("Hi! This is the robot controller (ROBOT 2)");
	?robotToken(Token);
	makeArtifact("r2","www.Robot",[Token],R);
	.wait(5000);
	!elbowright.

/*plan will not fail, because it has no belief and therefore will just not execute.*/
+!start : robotToken(Token) <- 
  .print("Hi! This is the robot controller (ROBOT 2)").


@testloop1
+!work : true <-
	.print("Executing operation:");
   //work [R];
   
	.wait(5000);
	!work.

 @moveRight
 +!elbowright : human(right) <- 
  .print("elbowRight");
  elbowbend [R];
  .wait(1000);
  !step.
  
 +!step : human (right) <-
   .print("step2");
   wristpick [R];
   .wait(1000);
   !steps.
   
+!steps : human(right) <-
  .print("step3");
  gripperopen [R];
  .wait(1000);
  !elbowright.
  
  
  @moveLeft
  +!elbowright : human(left) <-
    .print("left");
    for (.range(I,1,2)) {
       elbowbend [R];
       wristpick [R];
       gripperopen [R];
       gripperclose [R];
       wristtrans [R];      
       elbowtransp [R];
//      turn plate;
      elbowbend [R];
      wristpick [R];
      gripperopen [R]; 
      }
    .wait(3000);
    -repetition(1)
    !done.
 
 -!done: human (left) <-
    .print("Failevent Left");
    .wait(5000);
    !elbowright.
 
 +!done : human (left) <-
    .print("Completed");
    .wait(5000);
//    -repetition(1)
    !elbowright.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$jacamoJar/templates/org-obedient.asl") }
