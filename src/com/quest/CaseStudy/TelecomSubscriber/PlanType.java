package com.quest.CaseStudy.TelecomSubscriber;

public enum PlanType
{
    POSTPAID,
    PREPAID;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}


