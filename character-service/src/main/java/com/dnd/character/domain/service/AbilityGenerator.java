package com.dnd.character.domain.service;

import com.dnd.character.domain.model.Abilities;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class AbilityGenerator {

    private static final int[] STANDARD_ARRAY = {15, 14, 13, 12, 10, 8};
    private static final Random RANDOM = new Random();

    public Abilities generateStandardArray() {
        List<Integer> scores = Arrays.stream(STANDARD_ARRAY)
                .boxed().collect(java.util.stream.Collectors.toList());
        Collections.shuffle(scores, RANDOM);
        return new Abilities(
                scores.get(0), scores.get(1), scores.get(2),
                scores.get(3), scores.get(4), scores.get(5)
        );
    }

    public Abilities generateRolled() {
        int[] scores = new int[6];
        for (int i = 0; i < 6; i++) {
            scores[i] = rollFourDropLowest();
        }
        return new Abilities(scores[0], scores[1], scores[2],
                scores[3], scores[4], scores[5]);
    }

    private int rollFourDropLowest() {
        int[] rolls = {rollDie(), rollDie(), rollDie(), rollDie()};
        Arrays.sort(rolls);
        return rolls[1] + rolls[2] + rolls[3];
    }

    private int rollDie() {
        return RANDOM.nextInt(6) + 1;
    }
}
