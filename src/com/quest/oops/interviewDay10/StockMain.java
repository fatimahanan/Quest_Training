package com.quest.oops.interviewDay10;

import java.util.ArrayList;
import java.util.List;

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

        StockAnalyzer longestTrendStock = getStockWithLongestTrend(stocks);
        System.out.println("Stock with longest increasing trend: " + longestTrendStock.stockName);

    }

    public static StockAnalyzer getStockWithHighestAvgPrice(List<StockAnalyzer> stocks)
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

    public static StockAnalyzer getStockWithLongestTrend(List<StockAnalyzer> stocks)
    {
        StockAnalyzer longestTrendStock = null;
        int longestTrendLength = 0;
        for (StockAnalyzer stock : stocks)
        {
            int[] trend = stock.findLongestIncreasingTrend(stock.prices);
            if (trend[2] > longestTrendLength) {
                longestTrendLength = trend[2];
                longestTrendStock = stock;
            }
        }
        return longestTrendStock;
    }

}

