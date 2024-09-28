package com.tournament.performance.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties
public class PerformanceDTO {

    String id;
    String zeros;
    String fifties;
    String century;
    String Team;
    String Player;
    String Tournament;
    String Matches;
    @JsonProperty("Batting_Innings")
    String BattingInnings;
    @JsonProperty("Not_Out")
    String NotOut;
    String Runs;
    @JsonProperty("Highest_Score")
    String HighestScore;
    @JsonProperty("Batting_Average")
    String BattingAverage;
    @JsonProperty("Balls_Faced")
    String BallsFaced;
    @JsonProperty("Strike_Rate")
    String StrikeRate;
    String fours;
    String six;
    @JsonProperty("Bowling_Innings")
    String BowlingInnings;
    @JsonProperty("Overs_Bowled")
    String OversBowled;
    @JsonProperty("Maidens Bowled")
    String MaidensBowled;
    @JsonProperty("Runs Conceded")
    String RunsConceded;
    @JsonProperty("Wickets_Taken")
    String WicketsTaken;
    @JsonProperty("Best_Bowling_Figures")
    String BestBowlingFigures;
    @JsonProperty("Bowling Average")
    String BowlingAverage;
    @JsonProperty("Bowling Economy Rate")
    String BowlingEconomyRate;
    @JsonProperty("Bowling Strike Rate")
    String BowlingStrikeRate;
    @JsonProperty("4+ Innings Wickets")
    String fourPlusInningsWickets;
    @JsonProperty("5+ Innings Wickets")
    String fiveInningsWickets;
    @JsonProperty("Catches Taken")
    String CatchesTaken;
    @JsonProperty("Stumpings Made")
    String StumpingsMade;


}
