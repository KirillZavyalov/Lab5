package ru.ITMO.Collection;

import ru.ITMO.Utils.Printer;
import ru.ITMO.Readers.ReaderInterface;

public class ObjectConstructor {

    ReaderInterface reader;
    Printer printer = new Printer();

    String input;
    String name; //Поле не может быть null, Строка не может быть пустой
    Coordinates coordinates; //Поле не может быть null
    Long studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    FormOfEducation formOfEducation; //Поле не может быть null
    Semester semesterEnum; //Поле не может быть null
    Person groupAdmin; //Поле может быть null
    StudyGroup studyGroup;

    CollectionController cc;
    public ObjectConstructor(ReaderInterface reader, CollectionController cc) {
        this.reader = reader;
        this.cc = cc;
    }

    public StudyGroup createStudyGroup(){
        studyGroup = new StudyGroup(createName(), createCoordinates(), createStudentsCount(), createFOE(),
                createSemesterEnum(), createPerson());
        printer.print("Объект создан");
        return studyGroup;
    }

    public void updateStudyGroup(int id){
        StudyGroup updateObj = cc.findById(id);
        updateObj.setName(createName());
        updateObj.setCoordinates(createCoordinates());
        updateObj.setStudentsCount(createStudentsCount());
        updateObj.setFormOfEducation(createFOE());
        updateObj.setSemesterEnum(createSemesterEnum());
        updateObj.setGroupAdmin(createPerson());
    }

    private String createName() {
        printer.print("Начато саздание объекта группы");
        printer.print("Введите название группы (String):");

        boolean finish = false;

        while (finish != true) {
            input = reader.read().trim();
            if (input != "" && input != null) {
                name = input;
                finish = true;
            } else {
                printer.print("Некорректный ввод. Повторите попытку.");
            }
        }
        return name;

    }

    private Coordinates createCoordinates() {
        printer.print("Создание координат группы: ");
        printer.print("Введите x (double):");


        boolean finish = false;
        double x = 0;
        float y = 0;

        while (finish != true) {
            input = reader.read().trim();
            try {
                x = Double.parseDouble(input);
                finish = true;
            } catch (NumberFormatException e) {
                printer.print("Некорректный ввод. Повторите попытку.");
            }

        }
        finish = false;


        printer.print("Введите y (float):");


        while (finish != true) {
            input = reader.read().trim();
            try {
                y = Float.parseFloat(input);
                finish = true;
            } catch (NumberFormatException e) {
                printer.print("Некорректный ввод. Повторите попытку.");
            }
        }
        finish = false;

        return new Coordinates(x, y);
    }

    private Long createStudentsCount(){
        printer.print("Введите количество студентов в группе (Long):");

        boolean finish = false;

        while (finish != true) {
            input = reader.read().trim();
            if (input == "") {
                studentsCount = null;
                finish = true;
            } else {
                try {
                    Long.parseLong(input);
                    if (Long.parseLong(input) >= 0){
                        studentsCount = Long.parseLong(input);
                        finish = true;
                    } else {
                        printer.print("Число студентов не может быть меньше нуля!");
                    }
                } catch (NumberFormatException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            }
        }
        return studentsCount;
    }

    private FormOfEducation createFOE() {
        printer.print("Введите форму обучения:\n" +
                "    DISTANCE_EDUCATION,\n" +
                "    FULL_TIME_EDUCATION,\n" +
                "    EVENING_CLASSES");

        boolean finish = false;

        while (finish != true) {
            input = reader.read().trim();
            if (input != "") {
                try {
                    formOfEducation = FormOfEducation.valueOf(input);
                    finish = true;
                } catch (IllegalArgumentException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            }
        }
        return formOfEducation;
    }

    private Semester createSemesterEnum() {
        printer.print("Введите семестр обучения:\n" +
                "    SECOND,\n" +
                "    THIRD,\n" +
                "    FIFTH,\n" +
                "    SIXTH,\n" +
                "    SEVENTH");

        boolean finish = false;

        while (finish != true) {
            input = reader.read().trim();
            if (input != "") {
                try {
                    semesterEnum = Semester.valueOf(input);
                    finish = true;
                } catch (IllegalArgumentException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            }
        }
        return semesterEnum;
    }

    private Person createPerson() {
        printer.print("Создание админа группы:\n");

        boolean finish = false;

        String name = null; //Поле не может быть null, Строка не может быть пустой
        float weight = 0; //Значение поля должно быть больше 0
        Color eyeColor = null; //Поле не может быть null
        Color hairColor = null; //Поле не может быть null
        Country nationality = null; //Поле может быть null
        Location location = null; //Поле может быть null

        printer.print("Введите имя (String):");


        while (!finish) {
            input = reader.read().trim();
            if (input != "" && input != null) {
                name = input;
                finish = true;
            } else {
                printer.print("Некорректный ввод. Повторите попытку.");
            }
        }
        finish = false;

        printer.print("Введите вес (float):");

        while (finish != true) {
            input = reader.read().trim();
            try {
                if (Float.parseFloat(input) > 0) {
                    weight = Float.parseFloat(input);
                    finish = true;
                } else {
                    printer.print("Вес должен быть больше нуля.");
                }
            } catch (NumberFormatException e) {
                printer.print("Некорректный ввод. Повторите попытку.");
            }
        }
        finish = false;


        printer.print("Введите цвет глаз:\n " +
                "    - BLUE,\n" +
                "    - YELLOW,\n" +
                "    - ORANGE,\n" +
                "    - BLACK,\n" +
                "    - WHITE,\n" +
                "    - BROWN");

        while (finish != true) {
            input = reader.read().trim();
            if (input != "") {
                try {
                    eyeColor = Color.valueOf(input);
                    finish = true;
                } catch (IllegalArgumentException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            } else {printer.print("Введите цвет глаз.");}
        }
        finish = false;

        printer.print("Введите цвет волос:\n " +
                "    - BLUE,\n" +
                "    - YELLOW,\n" +
                "    - ORANGE,\n" +
                "    - BLACK,\n" +
                "    - WHITE,\n" +
                "    - BROWN");

        while (finish != true) {
            input = reader.read().trim();
            if (input != "") {
                try {
                    hairColor = Color.valueOf(input);
                    finish = true;
                } catch (IllegalArgumentException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            } else {printer.print("Введите цвет волос:");}
        }
        finish = false;

        printer.print("Введите страну происхождения:\n " +
                "    FRANCE,\n" +
                "    VATICAN,\n" +
                "    SOUTH_KOREA,\n" +
                "    NORTH_KOREA,\n" +
                "    JAPAN ");

        while (finish != true) {
            input = reader.read().trim();
            if (input != "") {
                try {
                    nationality = Country.valueOf(input);
                    finish = true;
                } catch (IllegalArgumentException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            } else {nationality = null;
            finish = true;}
        }
        finish = false;

        Float x = null; //Поле не может быть null
        float y = 0;
        String Lname = null;
        printer.print("Создание локации:");

        printer.print("Введите название локации (String).");
        while (!finish) {
            input = reader.read().trim();
            if (input != "") {
                Lname = input;
                finish = true;

            } else {
                Lname = null;
                finish = true;
                return new Person(name, weight, eyeColor, hairColor, nationality, location);

            }
        }
        finish = false;


        printer.print("Введите x (Float):");
        while (finish != true) {
            input = reader.read().trim();
            if (input == "") {
                printer.print("Значение не может быть null. Повторите попытку.");
            } else {
                try {
                    x = Float.parseFloat(input);
                    finish = true;
                } catch (NumberFormatException e) {
                    printer.print("Некорректный ввод. Повторите попытку.");
                }
            }
        }
        finish = false;


        printer.print("Введите y (float):");
        while (finish != true) {
            input = reader.read().trim();

            try {
                y = Float.parseFloat(input);
                finish = true;
            } catch (NumberFormatException e) {
                printer.print("Некорректный ввод. Повторите попытку.");
            }
        }
        finish = false;


        location = new Location(x, y, Lname);
        return new Person(name, weight, eyeColor, hairColor, nationality, location);
    }

}
