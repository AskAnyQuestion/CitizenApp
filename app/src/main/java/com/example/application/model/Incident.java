package com.example.application.model;

import android.annotation.SuppressLint;
import com.yandex.mapkit.geometry.Point;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class Incident {
    protected int idIncident;
    protected User user;
    protected String eventDescription;
    protected Timestamp eventTime;
    protected Double latitude;
    protected Double longitude;

    public Incident() {
    }

    public Incident(User user, String eventDescription, Point point) {
        this.eventTime = new Timestamp(new Date().getTime());
        this.eventDescription = eventDescription.substring(0, 1).toUpperCase()
                + eventDescription.substring(1);
        this.latitude = point.getLatitude();
        this.longitude = point.getLongitude();
        this.user = user;
    }

    public Incident(Integer idIncident, User user, String eventDescription, Point point) {
        this(user, eventDescription, point);
        this.idIncident = idIncident;
    }

    public User getUser() {
        return user;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Integer getId() {
        return idIncident;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Timestamp getTime() {
        TimeZone moscowTimeZone = TimeZone.getTimeZone(ZoneId.systemDefault());
        int offsetInMillis = moscowTimeZone.getRawOffset();
        Timestamp adjustedTime = new Timestamp(eventTime.getTime() + offsetInMillis);
        return adjustedTime;
    }

    @SuppressLint("DefaultLocale")
    public CharSequence getAlarmTime() {
        String[] monthNames = {"января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));
        String formattedTime = null;
        try {
            Date parsedDate = sdf.parse(eventTime.toString());
            assert parsedDate != null;
            int day = parsedDate.getDay();
            int month = parsedDate.getMonth();
            int hours = parsedDate.getHours();
            int minutes = parsedDate.getMinutes();
            formattedTime = String.format("%d %s %02d:%02d", day, monthNames[month - 1], hours, minutes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedTime;
    }

    @SuppressLint("DefaultLocale")
    public CharSequence getEventTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));
        String formattedTime = null;
        try {
            Date parsedDate = sdf.parse(eventTime.toString());
            assert parsedDate != null;
            int hours = parsedDate.getHours();
            int minutes = parsedDate.getMinutes();
            formattedTime = String.format("%02d:%02d", hours, minutes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedTime;
    }

    public void setIdIncident(Integer idIncident) {
        this.idIncident = idIncident;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
