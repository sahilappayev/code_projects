package org.mn.msaccount.service;


import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mn.msaccount.util.StringUtil;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = CalculationService.class)
class CalculationServiceTest {

    // TDD Test Driven Development
//    @InjectMocks
//    @Autowired
    private CalculationService calculationService;

    @BeforeEach
    public void init() {
        System.out.println("called init");
        calculationService = new CalculationService();
    }

    // Red, Green, Refactor
    @Test
    void test_add() {
        int actual = calculationService.add(1, 5);

        Assertions.assertEquals(6, actual);
    }

    @Test
    void test_add_2() {
        int actual = calculationService.add(1, 5);

        Assertions.assertEquals(6, actual);
    }

    // Static mocking
    @Test
    void test_getFullName() {
        String name = "Kamran";
        String surname = "Mammadov";

        String fullName = "Kamran Mammadov";

        try (MockedStatic<StringUtil> mock = Mockito.mockStatic(StringUtil.class)) {
            mock.when(() -> StringUtil.concatString(name, surname)).thenReturn(fullName);

            String actual = calculationService.getFullName(name, surname);

            Assertions.assertEquals(fullName, actual);
        }
    }


}
