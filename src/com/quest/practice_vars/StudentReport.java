package com.quest.practice_vars;

import java.util.Scanner;

public class StudentReport
{
    final static int MAX_SCORE = 100;
    public static void main(String[] args)
    {
        int numOfStudents=0;
        boolean startRangeFlag=true;
        Scanner sc=new Scanner(System.in);
        while(startRangeFlag)
        {
            System.out.println("Enter the number of students (1-100) : ");
            while (!sc.hasNextInt())
            {
                System.out.println("Error! Enter a valid number (integer) in the range 1-100.");
                sc.next();
            }
            numOfStudents=sc.nextInt();
            if(numOfStudents<1 || numOfStudents>MAX_SCORE) {
                System.out.println("Error! Enter in the range 1-100 : ");
            }
            else
                startRangeFlag=false;
        }
        for(int i=1;i<=numOfStudents;i++)
        {
            //entering name of student
            System.out.println("\nEnter the name of student "+i+" : ");
            String name=sc.next();
            //entering scores for each subject
            int mathScore=scoreValidation(sc,"Maths");
            int englishScore=scoreValidation(sc,"English");
            int scienceScore=scoreValidation(sc,"Science");
            //calculating total
            int totalScore=mathScore+englishScore+scienceScore;
            System.out.println("Total Score : "+totalScore);
            if(totalScore<50)
            {
                System.out.println("Total score is less than 50. Breaking... ");
                break;
            }
            //calculating average
            int averageScore=totalScore/3;
            System.out.println("Average Score : "+averageScore);
            //assigning grades
            char grade=GradeCalculation(averageScore);
            System.out.println("Grade : "+grade);
            //printing feedback
            String feedback=GradeFeedback(grade,mathScore,englishScore,scienceScore);
            System.out.println(feedback);
        }
    }

    private static char GradeCalculation(double averageScore)
    {
        if(averageScore>=90)
            return 'A';
        else if(averageScore>=80 && averageScore<90)
            return 'B';
        else if (averageScore>=70 && averageScore<80)
            return 'C';
        else if (averageScore>=60 && averageScore<70)
            return 'D';
        else
            return 'F';
    }

    private static String GradeFeedback(char grade, int mathScore, int englishScore, int scienceScore)
    {
        String feedback="";
        switch (grade) {
            case 'A':
                feedback = "Excellent performance!";
                break;
            case 'B':
                feedback = "Good job, but you can aim higher";
                break;
            case 'C':
                feedback = "You need to put in more effort.";
                break;
            case 'D':
                feedback = "Your performance is below expectations.";
                break;
            case 'F':
                feedback = "Failure, you need significant improvement.";
                break;
            default:
                feedback = "Invalid grade.";
        }
        if(mathScore<60 || scienceScore<60 || englishScore<60)
            feedback+="\nWarning : Needs improvement in individual subjects.";
        return feedback;
    }

    private static int scoreValidation(Scanner sc, String subject)
    {
        int score=-1;
        System.out.println("Enter the score for " + subject + "(1-" + MAX_SCORE + "): ");
        while(score<1||score>MAX_SCORE)
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Error! invalid input. Enter in range (1=100)");
                sc.next();
            }
            score=sc.nextInt();
            if(score<1 || score>MAX_SCORE)
            {
                System.out.println("Error! invalid input. Enter in range (1=100)");
            }
        }
        return score;
    }
}
