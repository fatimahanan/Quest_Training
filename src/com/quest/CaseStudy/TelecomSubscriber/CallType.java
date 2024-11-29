package com.quest.CaseStudy.TelecomSubscriber;

import java.time.LocalDateTime;

public enum CallType
{
    LOCAL,
    STD,
    ISD, callType;

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
