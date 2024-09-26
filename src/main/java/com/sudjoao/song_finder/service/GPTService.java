package com.sudjoao.song_finder.service;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GPTService {
    private final HttpClient client;

    private static final String apiKey = System.getenv("GPT_API_KEY");

    private static final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public GPTService() {
        this.client = HttpClient.newBuilder().build();
    }

    public String getResponse(String phrase) {
        String requestBody = """
            {
                "model": "gpt-3.5-turbo",
                "messages": [
                    {
                        "role": "system",
                        "content": "You are a helpful assistant."
                    },
                    {
                        "role": "user",
                        "content": "%s"
                    }
                ]
            }
        """.formatted(phrase);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .headers("Content-Type", "application/json", "Authorization", "Bearer %s".formatted(apiKey))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
