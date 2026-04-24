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
    public ResponseEntity<Identity> synthesize(@RequestBody Map<String, List<String>> request) {
        List<String> skills = request.get("skills");
        if (skills == null || skills.size() < 3) {
            return ResponseEntity.badRequest().build();
        }
        Identity result = synthesizerService.synthesizeIdentity(skills);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/skills")
    public ResponseEntity<Map<String, String>> getAllSkills() {
        return ResponseEntity.ok(synthesizerService.getSkillDatabase());
    }
}
