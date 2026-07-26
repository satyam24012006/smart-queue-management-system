package com.satyam.smartqueue.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalDoctors;
    private long totalDepartments;
    private long totalAppointments;
    private long todaysAppointments;
    private long waitingTokens;
    private long servingTokens;
    private long completedTokens;
    private long cancelledTokens;

    public DashboardResponse() {
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(long totalDoctors) {
        this.totalDoctors = totalDoctors;
    }

    public long getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(long totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public long getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(long totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public long getTodaysAppointments() {
        return todaysAppointments;
    }

    public void setTodaysAppointments(long todaysAppointments) {
        this.todaysAppointments = todaysAppointments;
    }

    public long getWaitingTokens() {
        return waitingTokens;
    }

    public void setWaitingTokens(long waitingTokens) {
        this.waitingTokens = waitingTokens;
    }

    public long getServingTokens() {
        return servingTokens;
    }

    public void setServingTokens(long servingTokens) {
        this.servingTokens = servingTokens;
    }

    public long getCompletedTokens() {
        return completedTokens;
    }

    public void setCompletedTokens(long completedTokens) {
        this.completedTokens = completedTokens;
    }

    public long getCancelledTokens() {
        return cancelledTokens;
    }

    public void setCancelledTokens(long cancelledTokens) {
        this.cancelledTokens = cancelledTokens;
    }
}
