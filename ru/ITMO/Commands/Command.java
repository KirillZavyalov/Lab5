package ru.ITMO.Commands;

import java.util.ArrayList;

/**
 *интерфейс команд
 */
public interface Command {

    void execute (ArrayList<String> arguments);

}
