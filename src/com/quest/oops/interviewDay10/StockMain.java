package com.quest.oops.interviewDay10;

import java.util.ArrayList;

public class StockMain
{
    public static void main(String[] args)
    {
        int[] equityPrices={180,185,190,175, 200, 210};
        int[] commodityPrices={1900,1950,2000,1850,1800,2050};

        StockAnalyzer equity=new EquityStockAnalyzer("Apple","AAPL", equityPrices,"Technology");
        StockAnalyzer commodity=new CommodityStockAnalyzer("Gold","GOLD", commodityPrices,"Gold");
        equity.displayAnalysis();
        System.out.println();
        commodity.displayAnalysis();

        ArrayList<StockAnalyzer> stocks = new ArrayList<>();
        stocks.add(equity);
        stocks.add(commodity);

        StockAnalyzer highestAvgPriceStock = getStockWithHighestAvgPrice(stocks);
        System.out.println("\nStock with highest average price: " + highestAvgPriceStock.stockName);
        String trendString = getStockWithLongestTrend(stocks);
        System.out.println("Stock with longest increasing trend: " + trendString);

    }

    public static StockAnalyzer getStockWithHighestAvgPrice(ArrayList<StockAnalyzer> stocks)
    {
        StockAnalyzer highestAvgPriceStock = null;
        double highestAvgPrice = Double.MIN_VALUE;
        for (StockAnalyzer stock : stocks)
        {
            double avgPrice = stock.calculateAveragePrice(stock.prices);
            if (avgPrice > highestAvgPrice)
            {
                highestAvgPrice = avgPrice;
                highestAvgPriceStock = stock;
            }
        }
        return highestAvgPriceStock;
    }

    public static String getStockWithLongestTrend(ArrayList<StockAnalyzer> stocks)
    {
        ArrayList<StockAnalyzer> longestTrend = new ArrayList<>();
        int longestTrendLength = 0;
        for (StockAnalyzer stock : stocks)
        {
            int[] trend = stock.findLongestIncreasingTrend(stock.prices);
            if (trend[2] > longestTrendLength)
            {
                longestTrendLength = trend[2];
                longestTrend.clear();
                longestTrend.add(stock);
            }
            else if (trend[2] == longestTrendLength)
            {
                // If the trend length is the same as the longest trend, add this stock to the list
                longestTrend.add(stock);
            }
        }
        StringBuilder trendString = new StringBuilder();
        for (StockAnalyzer stock : longestTrend)
        {
            trendString.append(stock.stockName).append(",");
        }
        if (trendString.length()>0)
        {
            trendString.setLength(trendString.length() - 1);
        }
        return trendString.toString(); // Return the formatted string
    }

}

