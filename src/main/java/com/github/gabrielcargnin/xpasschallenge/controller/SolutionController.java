package com.github.gabrielcargnin.xpasschallenge.controller;

import com.github.gabrielcargnin.xpasschallenge.entity.SolutionResponse;
import com.github.gabrielcargnin.xpasschallenge.service.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolutionController {

    private final Solution loopSolution;

    private final Solution mathSolution;

    @Autowired
    public SolutionController(Solution loopSolution, Solution mathSolution) {
        this.loopSolution = loopSolution;
        this.mathSolution = mathSolution;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/xpass-challenge/loop-solution/solve/{number}")
    public ResponseEntity<SolutionResponse> loopSolve(@PathVariable Integer number) {
        return getSolutionResponseResponseEntity(number, loopSolution);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/xpass-challenge/math-solution/solve/{number}")
    public ResponseEntity<SolutionResponse> mathSolve(@PathVariable Integer number) {
        return getSolutionResponseResponseEntity(number, mathSolution);
    }

    private ResponseEntity<SolutionResponse> getSolutionResponseResponseEntity(@PathVariable Integer number, Solution solution) {
        try {
            String solve = solution.solve(number);
            return ResponseEntity.ok(new SolutionResponse().setData(solve).setStatus("success").setStatusCode(200));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SolutionResponse().setStatus("error").setStatusCode(400)
                    .setMessage(e.getMessage()));
        }
    }

}