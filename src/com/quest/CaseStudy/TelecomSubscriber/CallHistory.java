package com.quest.CaseStudy.TelecomSubscriber;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CallHistory implements Serializable
{
    private String callType;
    private int durationInMinutes;
    private LocalDateTime timestamp;


    public CallHistory(String callType, int durationInMinutes, LocalDateTime timestamp) {
        this.callType = callType;
        this.durationInMinutes = durationInMinutes;
        this.timestamp = timestamp;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String formatDuration()
    {
        int hours=durationInMinutes/60;
        int minutes=durationInMinutes%60;
        return hours+":"+minutes;
    }

    @Override
    public String toString() {
        return "CallHistory{" +
                "callType='" + callType + '\'' +
                ", duration=" + formatDuration() +
                ", timestamp=" + timestamp +
                '}';
    }
}