package com.finalsurge.utils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
public class CreateWorkout {
    private String workoutDateOfActivity;
    private String workoutNameOfActivity;
    private String workoutDescriptionOfActivity;
    private String workoutDistance;
    private String workoutTimeOfActivity;
    private String workoutFactTimeOfActivity;
    private String workoutFactDistanceOfActivity;
    private String workoutOverallPlace;
    private String workoutAgeGroupPlace;
    private String workoutKCal;
}
