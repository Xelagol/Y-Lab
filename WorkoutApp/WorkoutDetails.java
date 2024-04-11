import java.time.LocalDate;
import java.util.Date;

public class WorkoutDetails implements Comparable<WorkoutDetails>
{
    LocalDate dateWorkout;
    String nameWorkout;
    String durationWorkout;
    String numberOfCalories;
    String info;

    public WorkoutDetails(LocalDate dateWorkout, String nameWorkout, String durationWorkout, String numberOfCalories)
    {
        this.dateWorkout = dateWorkout;
        this.nameWorkout = nameWorkout;
        this.durationWorkout = durationWorkout;
        this.numberOfCalories = numberOfCalories;
        info = "";
    }

    public WorkoutDetails(LocalDate dateWorkout, String nameWorkout, String durationWorkout, String numberOfCalories, String info)
    {
        this.dateWorkout = dateWorkout;
        this.nameWorkout = nameWorkout;
        this.durationWorkout = durationWorkout;
        this.numberOfCalories = numberOfCalories;
        this.info = info;
    }

    public LocalDate getDateWorkout()
    {
        return dateWorkout;
    }

    public void setDateWorkout(LocalDate dateWorkout)
    {
        this.dateWorkout = dateWorkout;
    }

    public String getNameWorkout()
    {
        return nameWorkout;
    }

    public void setNameWorkout(String nameWorkout)
    {
        this.nameWorkout = nameWorkout;
    }

    public String getDurationWorkout()
    {
        return durationWorkout;
    }

    public void setDurationWorkout(String durationWorkout)
    {
        this.durationWorkout = durationWorkout;
    }

    public String getNumberOfCalories()
    {
        return numberOfCalories;
    }

    public void setNumberOfCalories(String numberOfCalories)
    {
        this.numberOfCalories = numberOfCalories;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    @Override
    public int compareTo(WorkoutDetails o)
    {
        return this.getDateWorkout().compareTo(o.getDateWorkout());
    }

    @Override
    public String toString()
    {
        if (info.isEmpty())
        {
            return "Дата тренировки " + dateWorkout +
                    ", Название упражнения " + nameWorkout +
                    ", Продолжительность в минутах " + durationWorkout +
                    ", Количество сожженых каллорий " + numberOfCalories;
        } else {
            return "Дата тренировки " + dateWorkout +
                    ", Название упражнения " + nameWorkout +
                    ", Продолжительность в минутах " + durationWorkout +
                    ", Количество сожженых каллорий " + numberOfCalories +
                    ", Доп инфо " + info;
        }
    }
}
