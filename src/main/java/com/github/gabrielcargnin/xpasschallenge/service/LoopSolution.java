package com.github.gabrielcargnin.xpasschallenge.service;

import org.springframework.stereotype.Service;

@Service
public class LoopSolution implements Solution {

    /**
     * Method to determine which String to return. It uses while loops and return statements to decide which string it
     * should return.
     *
     * @param num the number.
     * @return Xpass, IT or XpassLovers string.
     * @throws Exception Throws exception when number is out of the 1-100 range.
     */
    public String solve(int num) throws Exception {
        if (num < 1 || num > 100) {
            throw new Exception("Number out of range!");
        }
        boolean isXpass = num % 3 == 0;
        boolean isIT = num % 5 == 0;

        while (isXpass && isIT) {
            return "XpassLovers";
        }
        while (isXpass) {
            return "Xpass";
        }
        while (isIT) {
            return "IT";
        }
        return String.valueOf(num);
    }

}
