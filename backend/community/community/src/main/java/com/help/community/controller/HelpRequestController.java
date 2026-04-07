package com.help.community.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.community.model.HelpRequest;
import com.help.community.repository.HelpRequestRepository;

@RestController
@RequestMapping("/help")
@CrossOrigin
public class HelpRequestController {

    private final HelpRequestRepository repo;

    public HelpRequestController(HelpRequestRepository repo) {
        this.repo = repo;
    }

    // ✅ GET ALL HELP REQUESTS
    @GetMapping
    public List<HelpRequest> getAll() {
        return repo.findAll();
    }

    // ✅ ADD HELP REQUEST
    @PostMapping
    public HelpRequest add(@RequestBody HelpRequest help) {
        return repo.save(help);
    }

    // ✅ UPDATE HELP REQUEST (FULL UPDATE)
    @PutMapping("/{id}")
    public HelpRequest update(@PathVariable Long id, @RequestBody HelpRequest help) {
        return repo.findById(id).map(h -> {
            h.setTitle(help.getTitle());
            h.setDescription(help.getDescription());
            h.setLocation(help.getLocation());
            h.setUserName(help.getUserName());
            h.setPhone(help.getPhone());
            h.setUrgency(help.getUrgency());
            h.setStatus(help.getStatus());
            return repo.save(h);
        }).orElseThrow(() -> new RuntimeException("Help request not found"));
    }

    // ✅ DELETE HELP REQUEST
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}