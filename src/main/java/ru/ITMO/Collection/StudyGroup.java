package ru.ITMO.Collection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * Класс хранимых в коллекции объектов.
 * @author Kirill Zavyalov
 */
public class StudyGroup implements Comparable<StudyGroup>{

    @JsonIgnore
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @JsonProperty("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonProperty("coordinates")
    private Coordinates coordinates; //Поле не может быть null
    @JsonProperty("creationdate")
    private java.time.LocalDate creationDate = java.time.LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @JsonProperty("studuntscount")
    private Long studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    @JsonProperty("formofeducation")
    private FormOfEducation formOfEducation; //Поле не может быть null
    @JsonProperty("semesterenum")
    private Semester semesterEnum; //Поле не может быть null
    @JsonProperty("groupAdmin")
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(){

    }

    @JsonCreator
    public StudyGroup(@JsonProperty("name") String name,
                      @JsonProperty("coordinates") Coordinates coordinates,
                      @JsonProperty("studuntscount") Long studentsCount,
                      @JsonProperty("formofeducation") FormOfEducation formOfEducation,
                      @JsonProperty("semesterenum") Semester semesterEnum,
                      @JsonProperty("groupAdmin") Person groupAdmin){
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup sg) {
        return Long.compare(this.getFormOfEducation().ordinal(), sg.getFormOfEducation().ordinal());
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public void setId(long nexdId) {
        id = nexdId;
    }
}

