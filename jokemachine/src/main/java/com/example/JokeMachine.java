package com.example;

import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

public class JokeMachine {


    private static JokesTO initJokes() {
        Gson gson = new Gson();
        JokesTO jokesTOs = gson.fromJson(JSON_JOKES, JokesTO.class);
        return jokesTOs;
    }

    private Random randomGenerator;

    private JokesTO jokesTOs;
    private static String JSON_JOKES = "{\r\n  \"Description\": \"Jokes from the inner webs\",\r\n  \"Credit\": \"https://gist.github.com/neelusb/559916bf7ff7091a20c818e86534f4cc\",\r\n  \"Jokes\": [\r\n    {\r\n      \"question\": \"What happens to a frog's car when it breaks down?\",\r\n      \"answer\": \"It gets toad away.\"\r\n    },\r\n    {\r\n      \"question\": \"What did the duck say when he bought lipstick?\",\r\n      \"answer\": \"Put it on my bill!\"\r\n    },\r\n    {\r\n      \"question\": \"My friend thinks he is smart. He told me an onion is the only food that makes you cry\",\r\n      \"answer\": \"so I threw a coconut at his face.\"\r\n    },\r\n    {\r\n      \"question\": \"A recent worldwide survey showed that out of 2,146,703,436 people\",\r\n      \"answer\": \"94% were too lazy to actually read that number.\"\r\n    },\r\n    {\r\n      \"question\": \"Did you hear about the kidnapping at school?\",\r\n      \"answer\": \"It's okay, he woke up.\"\r\n    },\r\n    {\r\n      \"question\": \"Can a kangaroo jump higher than the Empire State Building?\",\r\n      \"answer\": \"Of course. The Empire State Building can't jump!\"\r\n    },\r\n    {\r\n      \"question\": \"Why does Humpty Dumpty love autumn?\",\r\n      \"answer\": \"Because Humpty Dumpty had a great fall!\"\r\n    }\r\n  ]\r\n}";

    public Joke tellJoke() {

        if (jokesTOs == null || jokesTOs.getJokes().size() == 0) {
            jokesTOs = initJokes();
        }
        jokesTOs = initJokes();
        return randomJoke();
    }

    private Joke randomJoke() {
        List<Joke> jokes = jokesTOs.getJokes();

        if (jokes == null || jokes.size() <= 0) {
            return null;
        }

        randomGenerator = new Random();
        int index = randomGenerator.nextInt(jokes.size());
        Joke joke = jokes.get(index);
        return joke;
    }
}
