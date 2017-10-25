package epam.homework.hw4.taskTwo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Author {

    public enum Gender {
        male,
        female
    }

    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;

    public Author(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    public Author(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return (deathDate == null)
                ? (int) ChronoUnit.YEARS.between(this.getBirthDate(), LocalDate.now())
                : (int) ChronoUnit.YEARS.between(this.getBirthDate(), this.getDeathDate());
    }

    public boolean isDead() {
        return (deathDate != null);
    }

    @Override
    public String toString() {
        return "name: " + name + ",\ndate of birth: " + birthDate + ",\ndate of death: " + deathDate + ",\nage: " + getAge() + ",\ngender: " + gender.toString();
    }

    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res
                + ((name != null)
                        ? name.hashCode()
                        : 0);
        res = 31 * res
                + ((birthDate != null)
                        ? name.hashCode()
                        : 0);
        res = 31 * res
                + ((deathDate != null)
                        ? name.hashCode()
                        : 0);
        res = 31 * res
                + ((gender != null)
                        ? gender.hashCode()
                        : 0);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author)) {
            return false;
        }
        return o.hashCode() == this.hashCode();
    }

}
