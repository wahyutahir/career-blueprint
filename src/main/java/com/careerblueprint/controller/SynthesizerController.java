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
        String nickname = (String) request.get("nickname");
        @SuppressWarnings("unchecked")
        List<String> skills = (List<String>) request.get("skills");
        
        if (skills == null || skills.size() < 3) {
            return ResponseEntity.badRequest().build();
        }
        
        // Use nickname if provided, otherwise default to "Lo"
        if (nickname == null || nickname.trim().isEmpty()) {
            nickname = "Lo";
        }
        
        try {
            // Call Gemini API for AI-powered analysis
            String aiResponse = geminiService.analyzeSkills(nickname, skills);
            
            // Parse the JSON response from Gemini
            // The response should be in format: {"identitas_unik": "...", "kenapa_langka": "...", "jalur_monetisasi": "..."}
            Map<String, Object> result = new HashMap<>();
            result.put("analysis", aiResponse);
            result.put("nickname", nickname);
            result.put("skills", skills);
            
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            // Fallback to static logic if Gemini API fails
            Identity fallbackResult = synthesizerService.synthesizeIdentity(nickname, skills);
            Map<String, Object> fallbackResponse = new HashMap<>();
            fallbackResponse.put("title", fallbackResult.getTitle());
            fallbackResponse.put("description", fallbackResult.getDescription());
            fallbackResponse.put("monetizationPaths", fallbackResult.getMonetizationPaths());
            fallbackResponse.put("nickname", nickname);
            fallbackResponse.put("skills", skills);
            fallbackResponse.put("fallback", true);
            
            return ResponseEntity.ok(fallbackResponse);
        }
    }

    @GetMapping("/skills")
    public ResponseEntity<Map<String, String>> getAllSkills() {
        return ResponseEntity.ok(synthesizerService.getSkillDatabase());
    }
}
