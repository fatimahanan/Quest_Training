package com.quest.oops.interviewDay10;

public abstract class StockAnalyzer
{
    String stockName;
    String stockSymbol;
    int[] prices;

    public StockAnalyzer(String stockName, String stockSymbol, int[] prices)
    {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.prices = prices;
    }

    public abstract int findMaxPrice(int[] prices);
    public abstract int findMinPrice(int[] prices);
    public abstract double calculateAveragePrice(int[] prices);
    public abstract int[] findLongestIncreasingTrend(int[] prices);
    public abstract void displayAnalysis();

}
