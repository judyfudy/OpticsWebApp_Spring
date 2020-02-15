package com.bubnii.controller;

import com.bubnii.model.Worker;
import com.bubnii.service.interfaces.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/workerList")
public class WorkerListController {

    private final WorkerService workerService;

    public WorkerListController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public String workerList(final Model model) {
        final List<Worker> workerList = workerService.getAll();
        model.addAttribute("workers", workerList);

        return "workerList";
    }
}
