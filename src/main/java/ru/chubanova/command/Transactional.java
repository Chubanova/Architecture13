package ru.chubanova.command;

public interface Transactional extends Command {

    void backup();

    void rollback();

}
