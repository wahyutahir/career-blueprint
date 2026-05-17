package com.careerblueprint.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class GeminiService {

    private final OkHttpClient client;
    private final String apiKey;

    public GeminiService(@Value("${GEMINI_API_KEY}") String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public String analyzeSkills(String nickname, java.util.List<String> skills) throws IOException {
        String systemPrompt = "Anda adalah AI 'Skill Synthesizer' pendamping dari buku 'Bukan Siapa-Siapa' karya Wahyu Tahir. Tugas Anda adalah menganalisis 3 sampai 10 skill nanggung yang dimasukkan user, lalu merakitnya menjadi SATU Identitas Karir Baru yang unik, bernilai ekonomi tinggi, dan langka (Konsep Sapi Naik Sepeda).\n" +
                "Gunakan gaya bahasa santai ('gue-lo'), tegas, blak-blakan, agak menampar (punchy), tapi sangat logis dan membakar semangat. Hindari kata-kata klise seperti 'Content Creator', 'Digital Marketer', atau 'Freelancer' jika kombinasinya bisa dibuat lebih spesifik, mahal, dan tidak pasaran.\n" +
                "Kembalikan output data harus dalam format JSON murni agar mudah diparsing oleh sistem frontend:\n" +
                "{\n" +
                "  \"identitas_unik\": \"Nama profesi/identitas baru yang tajam dan tidak generik\",\n" +
                "  \"kenapa_langka\": \"Penjelasan 2-3 kalimat kenapa kombinasi skill nanggung ini jarang ada di pasaran dan bikin mereka gak punya saingan\",\n" +
                "  \"jalur_monetisasi\": \"Langkah konkret bagaimana identitas ini bisa menghasilkan uang atau dicari industri saat ini\"\n" +
                "}";

        String userPrompt = String.format("Nama: %s\nSkill: %s\n\nAnalisis skill-skill di atas dan berikan identitas karir unik yang bernilai tinggi.", 
                nickname, String.join(", ", skills));

        // Build the request body for Gemini API
        String requestBodyJson = String.format(
            "{\"contents\":[{\"parts\":[{\"text\":\"%s\"}]}]}",
            (systemPrompt + "\n\n" + userPrompt).replace("\"", "\\\"").replace("\n", "\\n")
        );

        Request request = new Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(requestBodyJson, MediaType.parse("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
            
            // Extract the generated text from Gemini response
            String generatedText = jsonResponse
                    .getAsJsonArray("candidates")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("content")
                    .getAsJsonArray("parts")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();
            
            return generatedText;
        }
    }
}
