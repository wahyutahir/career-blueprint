package com.careerblueprint.controller;

import com.careerblueprint.model.Identity;
import com.careerblueprint.service.SkillSynthesizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SynthesizerController {

    private final SkillSynthesizerService synthesizerService;

    public SynthesizerController(SkillSynthesizerService synthesizerService) {
        this.synthesizerService = synthesizerService;
    }

    @PostMapping("/synthesize")
    public ResponseEntity<Identity> synthesize(@RequestBody Map<String, Object> request) {
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
        
        Identity result = synthesizerService.synthesizeIdentity(nickname, skills);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/skills")
    public ResponseEntity<Map<String, String>> getAllSkills() {
        return ResponseEntity.ok(synthesizerService.getSkillDatabase());
    }
}
