package org.rodrigez.validation;

public interface Validator {
    void validate(Object o) throws BuildingProjectException;
}
