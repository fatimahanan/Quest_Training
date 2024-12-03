package com.quest.InterviewQ.interviewDay10;

public abstract class StockAnalyzer
{
    protected String stockName;
    protected String stockSymbol;
    protected int[] prices;

    public StockAnalyzer(String stockName, String stockSymbol, int[] prices)
    {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.prices = prices;
    }

    protected abstract int findMaxPrice(int[] prices);
    protected abstract int findMinPrice(int[] prices);
    protected abstract double calculateAveragePrice(int[] prices);
    protected abstract int[] findLongestIncreasingTrend(int[] prices);
    protected abstract void displayAnalysis();

}
