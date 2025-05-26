package org.mn.msaccount.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mn.msaccount.util.StringUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationService {

    // unit
    public int add(int a, int b) {
        log.info("called add with {} and {}", a, b);
        return topla(a, b);
    }


    private int topla(int a, int b) {
        return a + b;
    }


    public String getFullName(String firstName, String lastName) {
        return StringUtil.concatString(firstName, lastName);
    }

}
