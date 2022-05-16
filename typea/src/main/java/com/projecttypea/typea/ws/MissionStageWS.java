package com.projecttypea.typea.ws;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.projecttypea.typea.bean.Cadre;
import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.bean.Soutien;
import com.projecttypea.typea.service.MissionStageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MissionStageWS {
    @Autowired
    MissionStageService missionStageService;

    @PostMapping("/user/missionstageadd")
    public Long ajoutMissionStage(@RequestBody MissionStage mStage, HttpSession session) {
        return missionStageService.ajoutMissionStage(mStage, session);
    }

    @GetMapping("/user/missionstage/{id}")
    public Optional<MissionStage> findById(@PathVariable Long id) {
        return missionStageService.findById(id);
    }

    @Transactional
    @DeleteMapping("/deletemission/{id}")
    public void deleteById(Long id) {
        missionStageService.deleteById(id);
    }

    /*
     * @PutMapping("/user/updatemission/{id}")
     * public int updateMissionStage(Long id, MissionStage missionStage) {
     * return missionStageService.updateMissionStage(id, missionStage);
     * }
     */

    @GetMapping("/admin/missions")
    public List<MissionStage> findAll() {
        return missionStageService.findAll();
    }

    @PostMapping("/user/addmission")
    public int addMissionStage(@Valid @RequestBody MissionStage mission, HttpSession session) {
        return missionStageService.addMissionStage(mission, session);
    }

    @GetMapping("/user/getmStage")
    public List<MissionStage> findAllByUserEmail(HttpSession session) {
        return missionStageService.findAllByUserEmail(session);
    }

    @GetMapping("/admin/getmstage/{id}")
    public MissionStage getById(@PathVariable Long id) {
        return missionStageService.getById(id);
    }

}