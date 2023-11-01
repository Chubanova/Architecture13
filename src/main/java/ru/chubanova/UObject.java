package ru.chubanova;

public interface UObject {

    Object getProperty(String key);

    void setProperty(String key, Object value);
}
