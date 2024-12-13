package com.quest.CaseStudy.TelecomSubscriber;

import java.time.LocalDateTime;

public enum CallType
{
    LOCAL,
    STD,
    ISD;

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
