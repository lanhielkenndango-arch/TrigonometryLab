/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trigonometrylab;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author shadow
 */
public class TrigonometryLab {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.println("Lab Activity 2: Trigonometric Calculations with Control Structures ");
        System.out.println();

        System.out.println("Problem 1: Trigonometric Function Calculator");
        System.out.print("Enter Angle: ");
        double angle = input.nextDouble();

        double angleToRad = toRadians(angle);
        double sine = sin(angleToRad);
        double cosine = cos(angleToRad);
        double tangent = tan(angleToRad);

        System.out.println("1: Sine");
        System.out.println("2: Cosine");
        System.out.println("3: Tangent");
        System.out.println("4: All Three");
        int pick = input.nextInt();

        if (pick == 1) {
            System.out.println(" The Value of Sine is " + sine);
        } else if (pick == 2) {
            System.out.println(" The Value of Cosine is " + cosine);

        } else if (pick == 4) {
            System.out.println(" The Value of Sine is " + sine);
            System.out.println(" The Value of Cosine is " + cosine);
        } else if (pick == 3 || pick == 4) {
            if (abs(angle % 180) == 90) {
                System.out.println(" The Value of Tangent is Undefined ");

            } else {
                System.out.println(" The Value of Tangent is " + tangent);
            }

        } else {
            System.out.println(" Please Choose Between 1-4 Only ");
            return;
        }
        
            /*
            Critical Thinking Questions:
            
            1. Why do we need to convert angles from degrees to radians?
               - Because java.lang.Math in all trig functions treats it as radian not degrees so kung magbutang kog 90 degrees inside sa sin or cos or tan it treats as 90 radian and we know na ang 90 degree is pie over 2 radians so big difference in result             
            2. What makes tangent undefined at certain angles?
               - In 90 degree and 270 degree. Tangent is sin over cos, ang value sa sin in 90 deg. is 1 and cos is 0 and we know that denominator cannot be zero  
            3. How could you modify this program to also calculate reciprocal functions (cosecant, secant, cotangent)?
               - to use trigononometric reciprocal identity. in csc theta = 1/sin theta , sec theta = 1/cos theta, and cot theta = 1/tan theta 
            */        
        
        
        System.out.println();
        System.out.println("Problem 2: Angle Quadrant Detector");
        System.out.print("Input Angle in Degrees : ");
        double angle1 = input.nextDouble();

        angle1 = angle1 % 360;        // ilimit daan to 0 to 360. magamit ang modulo kay ma determined asa dapit nga quadrant ang higher value tungod sa remainder ang ihatag and ang 1 cycle mn pud kay 360
        if (angle < 0) {              
            angle1 = angle1 % 360 + 360;            // pwede mn negative ang  number so nag butang ko og condition para ma positive lng ang number betweeen 0-360
        }
                                                                // ADDD SUGAR TO COFFEE, ilhanan lng nako
        String position = "";                                   // QUADRANT 1 ALL +
        String signofSin = "";                                  // QUADRANT 2 SIN ONLY + , other -
        String signofCos = "";                                  // QUADRANT 3 TAN ONLY + , other -
        String signofTan = "";                                  // QUADRANT 4 COS ONLY + , other -

        if (angle1 == 0 || angle1 == 180 || angle1 == 360) {    // I use logical OR operator because only 1 value of the condition will hold true 
            position = " Lies on the x-axis ";
            signofSin = "0";
            signofCos = (angle1 % angle1 == 180) ? "-" : "+";
            signofTan = "0";
        } else if (angle1 == 90 || angle1 == 270) {
            position = " Lies on the y-axis ";
            signofSin = (angle1 % angle1 == 90) ? "+" : "-";
            signofCos = "0";
            signofTan = " Undefined Value ";
        } else if (angle1 > 0 && angle1 < 90) {                  // I use logical AND operator as both value holds true in certain conditions
            position = " Quadrant 1 ";
            signofSin = "+";
            signofCos = "+";
            signofTan = "+";
        } else if (angle1 > 90 && angle1 < 180) {
            position = " Quadrant 2 ";
            signofSin = "+";
            signofCos = "-";
            signofTan = "-";
        } else if (angle1 > 180 && angle1 < 270) {
            signofSin = "-";
            signofCos = "-";
            signofTan = "+";
        } else if (angle1 > 270 && angle1 < 360) {
            signofSin = "-";
            signofCos = "+";
            signofTan = "-";
        } 

        System.out.println();
        System.out.println(" --- Result --- ");
        System.out.println("Normalize:  " + angle1 + "°");
        System.out.println("The position is in " + position);
        System.out.println("The sign is " + signofSin);
        System.out.println("The sign is " + signofCos);
        System.out.println("The sign is " + signofTan);
        
        /*
        Critical Thinking Questions:
        
        1. Why is it important to normalize angles before determining their quadrant?
           - to know the angle in 0-360 degrees, to identify it easily, and it will look like that it is one cycle only                          
        2. How does the sign of trigonometric functions change across different quadrants?
           - it comes from the cartesian coordinates, ang cosine kay ang x, then and sine kay ang y, then ifollow by quadrant sign sa cartesian plane                              
        3. What special considerations are needed for angles exactly on the axes?
           - because these angles kay wala sa mga quadrant and other trigonometric function kay undefined                              
        */
        

        System.out.println();

        double a = 0;
        double b = 0;
        double c = 0;
        double aAngle = 0;
        double bAngle = 0;
        final double cAngle = 90;

        System.out.println("Problem 3: Right Triangle Solver ");
        System.out.println("Choose what you know");
        System.out.println("1: Two Sides ");
        System.out.println("2: One Side and One Angle ");
        byte pick1 = input.nextByte();

        if (pick1 == 1) {
            System.out.print("Enter side a : ");
            a = input.nextDouble();
            System.out.print("Enter side b : ");
            b = input.nextDouble();

            if (a <= 0 || b <= 0) {
                System.out.println(" Higher positive number only ");
                return;
            }

            // PYTHAGOREAN THEOREM WHERE c = sqaure root of a squared + b squared
            c = sqrt(pow(a, 2) + pow(b, 2));

            // ANGLES OF THE RIGHT TRIANGLE
            aAngle = toDegrees(atan(b / a));  // in a right triangle mostly side b is the opposite side and side a is the adjacent side, so no basis if I flip the b and a but I use b/a to specify the side
            bAngle = 90 - aAngle;

        } else if (pick1 == 2) {
            System.out.print(" Enter one side (a) : ");
            a = input.nextDouble();
            System.out.print(" Enter one angle (aAngle < 90) : ");
            aAngle = input.nextDouble();

            if (a <= 0 || aAngle <= 0 || aAngle >= 90) {
                System.out.println(" Invalid number. Put a number under given condition. ");
                return;

            } // remaining angle
            bAngle = 90 - aAngle;

            // remaining sides
            // using trigo function of SOH , CAH , TOA
            b = tan(aAngle) * a;
            c = sqrt(pow(a, 2) + pow(b, 2));

        } else {
            System.out.println("Invalid choice, pick 1 and 2 only.");
        }
        // area of the triangle in right triangle is half the product of a and b
        double area = 0.5 * a * b;

        System.out.println();
        System.out.println(" Output of Right Triangle ");
        System.out.println(" Side a is " + a);
        System.out.println(" Side b is " + b);
        System.out.println(" Side c or the hypotenuse is " + c);
        System.out.println(" Angle A is " + aAngle);
        System.out.println(" Angle B is " + bAngle);
        System.out.println(" Angle C is " + aAngle+bAngle + "==" + cAngle + " (right triangle) ");
        System.out.println("The area of the triangle is " + area);
        
        /*
        Critical Thinking Questions:
        
        1. Why must we validate that angles in a right triangle are less than 90°?
           - because if not it will be a oblique triangle           
        2. How does your program handle the different cases of known values?
           - to set a condition to pick between 1 and 2 , and to input the needed condition again to know the remaining unknown value              
        3. What would happen if a user entered values that don't form a valid right triangle?
           -            
        */

        System.out.println();

        System.out.println("Problem 4: Trigonometric Identity Verifier");
        System.out.print("Enter angle in degrees :  ");
        
        double degrees = input.nextDouble();
        double radians = Math.toRadians(degrees);

        double sin = sin(radians);
        double cos = cos(radians);
        double tan = tan(radians);
        double sec = 1 / cos;
        double sinDouble = sin(2 * radians);

        double tolerance = 1e-9;

        // Identity 1: sin²θ + cos²θ = 1
        double left1 = pow(sin, 2) + pow(cos, 2);
        double right1 = 1.0;
        System.out.println();
        System.out.println("Checking identity: sin²θ + cos²θ = 1");
        if (abs(left1 - right1) < tolerance) {
            System.out.println("✓ Identity holds.");
        } else {
            System.out.println("✗ Identity does not hold.");
            System.out.println("  Left: " + left1 + ", Right: " + right1);
            System.out.println("  Difference: " + abs(left1 - right1));
        }

        // Identity 2: 1 + tan²θ = sec²θ
        double left2 = 1 + pow(tan, 2);
        double right2 = pow(sec, 2);
        System.out.println();
        System.out.println("Checking identity: 1 + tan²θ = sec²θ");
        if (abs(left2 - right2) < tolerance) {
            System.out.println("✓ Identity holds.");
        } else {
            System.out.println("✗ Identity does not hold.");
            System.out.println("  Left: " + left2 + ", Right: " + right2);
            System.out.println("  Difference: " + abs(left2 - right2));
        }

        // Identity 3: sin(2θ) = 2sinθcosθ
        double left3 = sinDouble;
        double right3 = 2 * sin * cos;
        System.out.println();
        System.out.println("Checking identity: sin(2θ) = 2sinθcosθ");
        if (abs(left3 - right3) < tolerance) {
            System.out.println("✓ Identity holds.");
        } else {
            System.out.println("✗ Identity does not hold.");
            System.out.println("  Left: " + left3 + ", Right: " + right3);
            System.out.println("  Difference: " + abs(left3 - right3));
        }
       
        /*
        Critical Thinking Questions:
        
        1. Why do we need a tolerance when comparing floating-point values?
           -                             
        2. Which identity might be most susceptible to floating-point precision issues and why?
           -                     
        3. How could you extend this program to verify more complex identities?
           -              
        */
 
        System.out.println();
        System.out.println("Problem 5: Wave Properties Analyzer");
        System.out.println();
        
        // Input values
        System.out.print("Enter amplitude: ");
        double A = input.nextDouble();

        System.out.print("Enter frequency (Hz): ");
        double f = input.nextDouble();

        System.out.print("Enter phase shift (in degrees): ");
        double phaseDeg = input.nextDouble();

        System.out.print("Enter time (seconds): ");
        double t = input.nextDouble();

        // Convert phase to radians
        double phaseRad = toRadians(phaseDeg);

        // Calculate instantaneous wave value
        double value = A * sin(2 * PI * f * t + phaseRad);
        System.out.printf("\nInstantaneous wave value: %.4f\n", value);

        // Determine peak, trough, or zero-crossing
        double anglee = 2 * PI * f * t + phaseRad;
        double sinValue = sin(angle);

        if (abs(sinValue - 1) < 0.0001) {
            System.out.println("Wave is at a PEAK.");
        } else if (abs(sinValue + 1) < 0.0001) {
            System.out.println("Wave is at a TROUGH.");
        } else if (abs(sinValue) < 0.0001) {
            System.out.println("Wave is at a ZERO-CROSSING.");
        } else {
            System.out.println("Wave is at a GENERAL point.");
        }

        // Calculate next peak time
        double period = 1 / f;
        double timeToNextPeak = period / 4 - ((t + phaseRad / (2 * PI * f)) % (period / 2));
        double nextPeakTime = t + timeToNextPeak;

        System.out.printf("Next peak will be at: %.4f seconds\n", nextPeakTime);
        
        /*
        Critical Thinking Questions:
        
        1. How did you determine if the wave is at a peak or trough?
           -               
        2. What mathematical approach did you use to find the next peak?
           -               
        3. How would you modify this program to handle non-sinusoidal waves?
           -         
        */
             
     input.close();       
        
    }
}
