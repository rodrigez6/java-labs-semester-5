package org.rodrigez.validation;

import org.junit.Before;
import org.junit.Test;
import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.Project;
import org.rodrigez.validation.validator.BuildingProjectValidationException;
import org.rodrigez.validation.validator.BuildingProjectValidator;

import static org.junit.Assert.*;

public class BuildingProjectValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new BuildingProjectValidator();
    }

    @Test
    public void validate_OK() {
        Exception e = null;

        Project project = new BuildingProject(1,1,"sss");
        try {
            validator.validate(project);
        } catch (ValidationException e1) {
            e = e1;
        }

        assertNull(e);
    }

    @Test
    public void validate_ERROR_HousingClass() {
        Exception e = null;

        Project project = new BuildingProject(1,0,"sss");
        try {
            validator.validate(project);
        } catch (ValidationException e1) {
            e = e1;
        }

        assertNotNull(e);
        assertTrue(e instanceof BuildingProjectValidationException);
        assertEquals(e.getMessage(), "Housing class must be from 1 to 3");
    }

    @Test
    public void validate_ERROR_FloorsNumber() {
        Exception e = null;

        Project project = new BuildingProject(0,1,"sss");
        try {
            validator.validate(project);
        } catch (ValidationException e1) {
            e = e1;
        }

        assertNotNull(e);
        assertTrue(e instanceof BuildingProjectValidationException);
        assertEquals(e.getMessage(), "Floors number must be more than 0");
    }
}