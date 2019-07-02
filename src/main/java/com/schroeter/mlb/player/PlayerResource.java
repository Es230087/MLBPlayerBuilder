package com.schroeter.mlb.player;

public class PlayerResource {
    boolean chosen;
    String firstName;
    String lastName;
    String position;
    String batPosition;
    String throwPosition;
    String teamName;

    int homeRuns; //hr
    int hits; //h
    int runs; //r
    int atBats; //ab
    int totalBases; //tb
    int walks; //bb
    int strikeouts; //so
    int heightFeet;
    int heightInches;

    Float batAvg; //avg
    Float slugPercentage; //slg
    Float onBasePercentage; //obp
    Float pitchesPerPlateAppearance; //ppa

    //TB x (H + BB) / (AB + BB)
    Float runsCreated = (float) totalBases * (((float) hits) + (float) walks) / (((float) atBats) + (float) walks);



    public Float getPitchesPerPlateAppearance() {
        return pitchesPerPlateAppearance;
    }

    public void setPitchesPerPlateAppearance(Float pitchesPerPlateAppearance) {
        this.pitchesPerPlateAppearance = pitchesPerPlateAppearance;
    }

    public Float getRunsCreated() {
        return runsCreated;
    }

    public void setRunsCreated(Float runsCreated) {
        this.runsCreated = runsCreated;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBatPosition() {
        return batPosition;
    }

    public void setBatPosition(String batPosition) {
        this.batPosition = batPosition;
    }

    public String getThrowPosition() {
        return throwPosition;
    }

    public void setThrowPosition(String throwPosition) {
        this.throwPosition = throwPosition;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public Float getBatAvg() {
        return batAvg;
    }

    public void setBatAvg(Float batAvg) {
        this.batAvg = batAvg;
    }

    public Float getSlugPercentage() {
        return slugPercentage;
    }

    public void setSlugPercentage(Float slugPercentage) {
        this.slugPercentage = slugPercentage;
    }

    public Float getOnBasePercentage() {
        return onBasePercentage;
    }

    public void setOnBasePercentage(Float onBasePercentage) {
        this.onBasePercentage = onBasePercentage;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public int getTotalBases() {
        return totalBases;
    }

    public void setTotalBases(int totalBases) {
        this.totalBases = totalBases;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
