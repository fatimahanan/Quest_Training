package com.quest.CaseStudy.ServiceCentreOperations;

import java.util.HashSet;
import java.util.Set;

public class ServiceCentre <T extends Vehicle>
{
    private Set<T> servicedVehicleSet;

    public ServiceCentre()
    {
        servicedVehicleSet = new HashSet<>();
    }

    public void addServicedVehicle(T vehicle)
    {
        servicedVehicleSet.add(vehicle);
    }

    public Set<T> getAllServicedVehicles()
    {
        return servicedVehicleSet;
    }
}
