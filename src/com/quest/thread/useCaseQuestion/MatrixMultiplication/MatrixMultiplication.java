package com.quest.thread.useCaseQuestion.MatrixMultiplication;

public class MatrixMultiplication extends Thread
{
    private int row;
    private int commonN;
    private int[][] a;
    private int[][] b;
    private int[][] result;

    public MatrixMultiplication(int row, int commonN, int[][] a, int[][] b, int[][] result) {
        this.row = row;
        this.commonN = commonN;
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Override
    public void run() {
        for(int i=0;i<b[0].length;i++) //each column in b
        {
            result[row][i]=0;
            for(int j=0;j<commonN;j++)
            {
                result[row][i]+=a[row][j]*b[j][i];
            }
        }
    }
}
