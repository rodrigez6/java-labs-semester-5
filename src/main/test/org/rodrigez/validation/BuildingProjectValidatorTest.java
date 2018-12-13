package org.rodrigez.validation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.rodrigez.model.BuildingProject;
import org.rodrigez.model.Project;
import org.rodrigez.validation.validator.BuildingProjectValidationException;
import org.rodrigez.validation.validator.BuildingProjectValidator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class BuildingProjectValidatorTest {

    @Parameterized.Parameter()
    public int floorsNumber;
    @Parameterized.Parameter(1)
    public int housingClass;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public Class<? extends Exception> expectedException;
    @Parameterized.Parameter(4)
    public String expectedExceptionMessage;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1,1,"sss",null,null},
                {1,0,"sss",BuildingProjectValidationException.class,"Housing class must be from 1 to 3"},
                {0,1,"sss",BuildingProjectValidationException.class,"Floors number must be more than 0"}
        });
    }

    private Validator validator;

    @Before
    public void setUp() {
        validator = new BuildingProjectValidator();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void validate(){
        Project project = new BuildingProject(floorsNumber,housingClass,address);
        try {
            validator.validate(project);
        } catch (ValidationException e) {
            assertEquals(e.getClass(), expectedException);
            assertEquals(e.getMessage(), expectedExceptionMessage);
        }
    }
}