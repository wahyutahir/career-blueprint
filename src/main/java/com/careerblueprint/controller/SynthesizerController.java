package com.careerblueprint.controller;

import com.careerblueprint.model.Identity;
import com.careerblueprint.service.GeminiService;
import com.careerblueprint.service.SkillSynthesizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SynthesizerController {

    private final SkillSynthesizerService synthesizerService;
    private final GeminiService geminiService;

    public SynthesizerController(SkillSynthesizerService synthesizerService, GeminiService geminiService) {
        this.synthesizerService = synthesizerService;
        this.geminiService = geminiService;
    }

    @PostMapping("/synthesize")
    public ResponseEntity<Map<String, Object>> synthesize(@RequestBody Map<String, Object> request) {
        System.out.println("=== BACKEND REQUEST RECEIVED ===");
        System.out.println("Request body: " + request);
        
        String nickname = (String) request.get("nickname");
        @SuppressWarnings("unchecked")
        List<String> skills = (List<String>) request.get("skills");
        
        System.out.println("Nickname: " + nickname);
        System.out.println("Skills: " + skills);
        
        if (skills == null || skills.size() < 3) {
            System.out.println("ERROR: Invalid skills count");
            return ResponseEntity.badRequest().build();
        }
        
        // Use nickname if provided, otherwise default to "Lo"
        if (nickname == null || nickname.trim().isEmpty()) {
            nickname = "Lo";
        }
        
        try {
            System.out.println("Calling Gemini API...");
            // Call Gemini API for AI-powered analysis
            String aiResponse = geminiService.analyzeSkills(nickname, skills);
            
            System.out.println("AI Response received: " + aiResponse);
            
            // Parse the JSON response from Gemini
            // The response should be in format: {"identitas_unik": "...", "kenapa_langka": "...", "jalur_monetisasi": "..."}
            Map<String, Object> result = new HashMap<>();
            result.put("analysis", aiResponse);
            result.put("nickname", nickname);
            result.put("skills", skills);
            
            System.out.println("Returning AI response to frontend");
            System.out.println("=== BACKEND RESPONSE END ===");
            
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            System.out.println("ERROR: Gemini API failed - " + e.getMessage());
            e.printStackTrace();
            
            // Fallback to static logic if Gemini API fails
            System.out.println("Using fallback static logic");
            Identity fallbackResult = synthesizerService.synthesizeIdentity(nickname, skills);
            Map<String, Object> fallbackResponse = new HashMap<>();
            fallbackResponse.put("title", fallbackResult.getTitle());
            fallbackResponse.put("description", fallbackResult.getDescription());
            fallbackResponse.put("monetizationPaths", fallbackResult.getMonetizationPaths());
            fallbackResponse.put("nickname", nickname);
            fallbackResponse.put("skills", skills);
            fallbackResponse.put("fallback", true);
            
            System.out.println("Returning fallback response to frontend");
            System.out.println("=== BACKEND RESPONSE END ===");
            
            return ResponseEntity.ok(fallbackResponse);
        }
    }

    @GetMapping("/skills")
    public ResponseEntity<Map<String, String>> getAllSkills() {
        return ResponseEntity.ok(synthesizerService.getSkillDatabase());
    }
}
