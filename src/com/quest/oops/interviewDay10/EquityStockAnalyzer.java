package com.quest.oops.interviewDay10;

public class EquityStockAnalyzer extends StockAnalyzer
{
    String sector;

    public EquityStockAnalyzer(String stockName, String stockSymbol, int[] prices, String sector)
    {
        super(stockName, stockSymbol, prices);
        this.sector = sector;
    }

    public int findMaxPrice(int[] prices)
    {
        int maxPrice=0;
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i]>maxPrice)
                maxPrice=prices[i];
        }
        return maxPrice;
    }

    public int findMinPrice(int[] prices)
    {
        int minPrice=1000;
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i]<minPrice)
                minPrice=prices[i];
        }
        return minPrice;
    }

    public double calculateAveragePrice(int[] prices)
    {
        double sum=0;
        double avgPrice=0;
        for(int i=0; i<prices.length; i++)
            sum+=prices[i];
        avgPrice=sum/prices.length;
        return avgPrice;
    }

    public int[] findLongestIncreasingTrend(int[] prices)
    {
        int startDay=0;
        int endDay=0;
        int maximumLength =0;
        int currentLength=1;
        int currentStart=0;
        for (int i=1; i<prices.length; i++)
        {
            if (prices[i]>prices[i-1])      //compared w previous day
            {
                currentLength++;
            }
            else
            {
                if (currentLength>maximumLength)  //new longest trend
                {
                    maximumLength=currentLength;
                    startDay=currentStart;
                    endDay=i-1;
                }
                currentLength=1;
                currentStart=i;
            }
        }
        if (currentLength > maximumLength)   //for last day
        {
            maximumLength=currentLength;
            startDay=currentStart;
            endDay=prices.length-1;
        }
        return new int[]{startDay, endDay, maximumLength};
    }

    public void displayAnalysis()
    {
        System.out.println("Analysis for Equity Stock");
        System.out.println("Stock Name : "+stockName);
        System.out.println("Stock Symbol : "+stockSymbol);
        System.out.println("Sector: " + sector);
        System.out.println("Highest Price: " + findMaxPrice(prices));
        System.out.println("Lowest Price: " + findMinPrice(prices));
        System.out.println("Average Price: " + calculateAveragePrice(prices));
        int[] longestIncreasingTrend = findLongestIncreasingTrend(prices);
        System.out.println("Longest Increasing Trend: \nStart Day "+longestIncreasingTrend[0]+"- End Day "+longestIncreasingTrend[1]+": Length - " + longestIncreasingTrend[2]);
    }
}

