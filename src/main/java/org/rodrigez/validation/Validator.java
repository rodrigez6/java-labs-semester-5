package org.rodrigez.validation;

import org.rodrigez.model.BuildingProjectException;

public interface Validator {
    void validate(Object o) throws BuildingProjectException;
}
