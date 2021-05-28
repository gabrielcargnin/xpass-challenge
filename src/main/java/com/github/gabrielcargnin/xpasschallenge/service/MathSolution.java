package com.github.gabrielcargnin.xpasschallenge.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MathSolution implements Solution {

    private final HashMap<Double, String> outputMap;

    public MathSolution() {
        outputMap = new HashMap<>();
        outputMap.put(0D, "XpassLovers");
        outputMap.put(6D, "Xpass");
        outputMap.put(10D, "IT");
    }

    /**
     * Method solving the challenge using a mathematical approach, using Euler's totient theorem.
     * The proposition is:
     *
     *  num^4 mod 15 = 0, if num is divisible by 3 and 5
     *                 6, if num is divisible by 3 and coprime to 5
     *                 10, if num is divisible by 5 and coprime to 3
     *                 1, if num is coprime to 3 and 5
     *
     * @param num the number
     * @return Xpass, IT or XpassLovers string.
     * @throws Exception Throws exception when number is out of the 1-100 range.
     */
    public String solve(int num) throws Exception {
        if (num < 1 || num > 100) {
            throw new Exception("Number out of range!");
        }
        outputMap.put(1D, String.valueOf(num));

        return outputMap.get(Math.pow(num, 4) % 15);
    }

}
