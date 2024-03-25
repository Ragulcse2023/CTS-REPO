package com.cognizant.fly.bean;




public class Flight {

    private long id;
    private String flightId;
    private double childFarePercentage;
    private double adultFare;

    /**
     * @return flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @param flightId
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * @return childFarePercentage
     */
    public double getChildFarePercentage() {
        return childFarePercentage;
    }

    /**
     * @param childFarePercentage
     */
    public void setChildFarePercentage(double childFarePercentage) {
        this.childFarePercentage = childFarePercentage;
    }

    /**
     * @return adultFare
     */
    public double getAdultFare() {
        return adultFare;
    }

    /**
     * @param adultFare
     */
    public void setAdultFare(double adultFare) {
        this.adultFare = adultFare;
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", childFarePercentage=" + childFarePercentage + ", adultFare="
                + adultFare + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
