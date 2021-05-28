package com.github.gabrielcargnin.xpasschallenge.util;

import com.github.gabrielcargnin.xpasschallenge.service.Solution;

public class ChallengePrinter {

    public void print(Solution solution) {
        for (int i = 1; i <= 100; i++) {
            try {
                System.out.println(solution.solve(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
