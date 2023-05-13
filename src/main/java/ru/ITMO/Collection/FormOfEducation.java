package ru.ITMO.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FOE")
public enum FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;
}
