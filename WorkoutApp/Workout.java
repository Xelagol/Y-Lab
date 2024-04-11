import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Workout
{
    String name;

    //    ArrayList<String> workout = new ArrayList<>();
//    Map<String, ArrayList<String>> workoutDetails = new HashMap<>();
    Map<String, ArrayList<WorkoutDetails>> userWorkout = new HashMap<>();

    public void setUserName(String name)
    {
        this.name = name;
        getWorkoutList(name);
    }

    private void getWorkoutList(String name)
    {
        System.out.println("Список Ваших тренировок:\n" +
                userWorkout.get(name));
    }

//    public ArrayList<String> addWorkoutDetails(String dateWorkout, String nameWorkout, String durationWorkout, String numberOfCalories)
//    {
//        WorkoutDetails woDetails = new WorkoutDetails(dateWorkout, nameWorkout, durationWorkout, numberOfCalories);
//        wor
////        ArrayList<String> workout = new ArrayList<>();
////        workout.add(dateWorkout);
////        workout.add(nameWorkout);
////        workout.add(durationWorkout);
////        workout.add(numberOfCalories);
//        return workout;
//    }

    public ArrayList<String> addWorkoutDetails(String dateWorkout, String nameWorkout, String durationWorkout,
                                               String numberOfCalories, String info)
    {
        ArrayList<String> workout = new ArrayList<>();
        workout.add(dateWorkout);
        workout.add(nameWorkout);
        workout.add(durationWorkout);
        workout.add(numberOfCalories);
        workout.add(info);
        return workout;
    }

    public void addWorkoutForUser(String name, WorkoutDetails workout)
    {
        if (userWorkout.containsKey(name))
        {
            ArrayList<WorkoutDetails> workoutList = new ArrayList<>();
            workoutList = userWorkout.get(name);
            workoutList.add(workout);
            userWorkout.remove(name);
            userWorkout.put(name, workoutList);
            System.out.println("Тренировка " + workout + " добавлена \n");
        } else
        {
            ArrayList<WorkoutDetails> workoutList = new ArrayList<>();
            workoutList.add(workout);
            userWorkout.put(name, workoutList);
            System.out.println("Тренировка " + workout + " добавлена \n");
        }
    }

    public void getWorkout(String name)
    {
        ArrayList<WorkoutDetails> wd = new ArrayList<>();
        wd = userWorkout.get(name);
        Collections.sort(wd);
        System.out.println("Список Ваших тренировок\n");
        wd.forEach(v ->
                System.out.println(v));
    }
}
