package com.careerblueprint.controller;

import com.careerblueprint.model.DailyMission;
import com.careerblueprint.service.MissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/missions")
@CrossOrigin(origins = "*")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/{day}")
    public ResponseEntity<DailyMission> getMissionByDay(@PathVariable int day) {
        if (day < 1 || day > 90) {
            return ResponseEntity.badRequest().build();
        }
        DailyMission mission = missionService.getMissionByDay(day);
        return ResponseEntity.ok(mission);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, DailyMission>> getAllMissions() {
        return ResponseEntity.ok(missionService.getAllMissions());
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Integer>> getTotalDays() {
        return ResponseEntity.ok(Map.of("totalDays", missionService.getTotalDays()));
    }

    @PostMapping("/complete/{day}")
    public ResponseEntity<Map<String, Object>> completeMission(@PathVariable int day, @RequestBody Map<String, Object> request) {
        DailyMission mission = missionService.getMissionByDay(day);
        if (mission == null) {
            return ResponseEntity.badRequest().build();
        }
        
        mission.setCompleted(true);
        
        // Generate RPG-style completion message
        String completionMessage = generateCompletionMessage(mission);
        
        return ResponseEntity.ok(Map.of(
            "success", true,
            "mission", mission,
            "message", completionMessage
        ));
    }

    private String generateCompletionMessage(DailyMission mission) {
        String phase = mission.getPhase();
        String reward = mission.getReward();
        
        if ("BONUS_DAY".equals(mission.getBonusDay())) {
            return "🎉 BONUS DAY SELESAI! " + reward + " Kamu layak mendapat istirahat ini. Besok kembali dengan energi baru!";
        }
        
        switch (phase) {
            case "DEEP CLEANING":
                return "✨ DEEP CLEANING SELESAI! " + reward + " Mental Nyam-Nyam berkurang. Ruang untuk hal baru terbuka.";
            case "INSTALLATION":
                return "🔧 INSTALLATION SELESAI! " + reward + " Bambu kamu sedang diraut. Siap terbang lebih tinggi.";
            case "MARKET LAUNCH":
                return "🚀 MARKET LAUNCH SELESAI! " + reward + " Satu langkah lagi menuju panggung utama. Kamu bukan figuran!";
            default:
                return "✅ MISI SELESAI! " + reward;
        }
    }
}
