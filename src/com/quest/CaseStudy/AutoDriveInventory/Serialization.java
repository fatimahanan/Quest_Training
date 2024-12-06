package com.quest.CaseStudy.AutoDriveInventory;

import java.io.*;
import java.util.Map;
import java.util.Set;

public class Serialization
{
    public static void saveData(Map<Customer, Set<Vehicle>> customerVehicleMap)
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("salesData.ser")))
        {
            out.writeObject(customerVehicleMap);
            System.out.println("Data serialized successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Map<Customer, Set<Vehicle>> loadData()
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("salesData.ser")))
        {
            return (Map<Customer, Set<Vehicle>>) in.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
