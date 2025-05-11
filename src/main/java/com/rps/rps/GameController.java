package com.rps.rps;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @PostMapping("/game")
    public Map<String, String> play(@RequestParam int choice) {
        String[] choices = { "Rock", "Scissors", "Paper" };
        int aiChoice = new Random().nextInt(3);

        String result;
        if (choice == aiChoice) {
            result = "Draw!";
        } else if ((choice == 0 && aiChoice == 1) ||
                   (choice == 1 && aiChoice == 2) ||
                   (choice == 2 && aiChoice == 0)) {
            result = "You win!";
        } else {
            result = "You lose!";
        }

        Map<String, String> response = new HashMap<>();
        response.put("result", result);
        response.put("computerChoice", choices[aiChoice]);
        return response;
    }
}
