package com.quest.practice_vars;

public class StudentScores
{
    public static void main(String[] args)
    {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"};
        int[] ages = {20, 21, 22, 23, 24, 25, 26};
        int[][] scores = {
                {85, 90, 78, 92, -1},
                {88, 92, 80, -1, 85},
                {75, 80, 70, 60, 72},
                {90, 85, 88, 95, 92},
                {65, 70, 60, 68, 67},
                {80, 85, -1, 90, 95},
                {90, 88, 92, 85, 80}
        };
        System.out.println("Displaying average scores...");
        double[] avgScores=calculateAverageScores(names, ages, scores);
        System.out.println("\nDisplaying details of highest scorer...");
        findHighestScorer(names, ages, avgScores);
        System.out.println("\nDisplaying rank of students...");
        rankStudents(names, ages, avgScores);
        System.out.println("\nDetecting missing scores...");
        detectMissingData(names,scores);
    }
    private static double[] calculateAverageScores(String[] names, int[] ages, int[][] scores)
    {
        double[] avgScores = new double[names.length];
        for (int i=0;i<names.length;i++)
        {
            String sName=names[i];
            int sAge=ages[i];
            int[] sScores=scores[i];

            int totalScore=0;
            int count=0;
            for (int score : sScores)
            {
                if (score!=-1)
                {
                    totalScore+=score;
                    count++;
                }
            }
            avgScores[i] = (double)totalScore/count;
            System.out.println("Average score of "+sName+" ("+sAge+" years) is : "+avgScores[i]);
        }
        return avgScores;
    }

    private static void findHighestScorer(String[] names, int[] ages, double[] avgScores)
    {
        double highestAvgScore = -1;
        String highestScorer = " ";
        int highestScorerAge = 0;

        for (int i = 0; i < names.length; i++)
        {
            if (avgScores[i]>highestAvgScore)
            {
                highestAvgScore=avgScores[i];
                highestScorer=names[i];
                highestScorerAge=ages[i];
            }
        }
        System.out.println("Highest scorer based on average is " + highestScorer + " (" + highestScorerAge + " years) with average score of " + highestAvgScore);
    }

    private static void rankStudents(String[] names, int[] ages, double[] avgScores)
    {
        for(int i=0; i<avgScores.length;i++)
        {
            for (int j=i+1; j<avgScores.length; j++)
            {
                if (avgScores[i]<avgScores[j])
                {
                    double temp=avgScores[i];
                    avgScores[i]=avgScores[j];
                    avgScores[j]=temp;
                    String tempName=names[i];
                    names[i]=names[j];
                    names[j]=tempName;

                    int tempAge=ages[i];
                    ages[i]=ages[j];
                    ages[j]=tempAge;
                }
            }
        }
        for (int i=0; i<names.length; i++)
        {
            System.out.println("Rank "+(i + 1)+ " - "+names[i] + " (" + ages[i] + " years) -  average score : " + avgScores[i]);
        }
    }

    public static void detectMissingData(String[] names, int[][] scores)
    {
        String[] subjects = {"Math", "Science", "Hindi", "English", "History"};

        for (int i=0; i<names.length; i++)
        {
            String sName = names[i];
            int[] sScores = scores[i];
            boolean hasMissingData = false;
            StringBuilder missingSubjects = new StringBuilder();
            for (int j=0; j<sScores.length; j++)
            {
                if (sScores[j]==-1)
                {
                    if (missingSubjects.length()>0)
                    {
                        missingSubjects.append(", ");
                    }
                    missingSubjects.append(subjects[j]);
                    hasMissingData=true;
                }
            }
            if (hasMissingData)
            {
                System.out.println(sName + " has missing scores in : " + missingSubjects);
            }
            else
            {
                System.out.println(sName + " has no missing scores.");
            }
        }
    }
}

