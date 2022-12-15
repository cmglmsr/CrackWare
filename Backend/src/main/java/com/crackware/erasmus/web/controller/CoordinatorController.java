package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Status;
import com.crackware.erasmus.data.security.requests.ScheduleRequest;
import com.crackware.erasmus.data.security.requests.ToDoRequest;
import com.crackware.erasmus.data.services.*;
import com.crackware.erasmus.data.services.helper.HelperService;
import com.crackware.erasmus.data.services.helper.ScheduleHelper;
import com.crackware.erasmus.data.services.helper.ToDoListHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping({"/coordinator", "coordinator"})
public class CoordinatorController {

    private final CoordinatorService coordinatorService;
    //private final DocumentServiceImpl documentServiceSave;
    private final HelperService helperService;

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    private final ToDoListItemService toDoListItemService;

    private final ScheduleService scheduleService;


    public CoordinatorController(CoordinatorService coordinatorService, HelperService helperService, ToDoListService toDoListService, TaskService taskService, ToDoListItemService toDoListItemService, ScheduleService scheduleService) {
        this.coordinatorService = coordinatorService;
        //this.documentServiceSave = documentServiceSave;
        this.helperService = helperService;
        this.toDoListService = toDoListService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/home")
    public Coordinator coordinatorHome() {
       return (Coordinator) helperService.getUser();
    }
    @GetMapping("/profile")
    public Coordinator coordinatorProfile() {
        return (Coordinator) helperService.getUser();
    }

    @PostMapping("/home")
    public void approveLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreementFile) throws IOException {
        String name = learningAgreementFile.getName();
        String type = learningAgreementFile.getContentType();
        Status documentStatus = Status.APPROVED;
        byte[] dataSize = learningAgreementFile.getBytes();
        Document learningAgreementDocument = new Document(name, type, dataSize, documentStatus);

        // Save the document
        //documentServiceSave.save(learningAgreementDocument);
        // Print out an approved message
        System.out.println("[+] Learning agreement file approved.");
    }

    public void rejectLearningAgreement(@RequestParam("learningAgreement") MultipartFile learningAgreementFile) throws IOException {
        String name = learningAgreementFile.getName();
        String type = learningAgreementFile.getContentType();
        Status documentStatus = Status.DENIED;
        byte[] dataSize = learningAgreementFile.getBytes();
        Document learningAgreementDocument = new Document(name, type, dataSize, documentStatus);

        // Save the document
        //documentServiceSave.save(learningAgreementDocument);
        // Print out an approved message
        System.out.println("[-] Learning agreement file rejected.");
    }

    @PostMapping("/todolist")
    public void coordinatorToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);

        if (toDoListItem.isDone()){
            toDoListItemService.delete(toDoListItem);
        }else {
            toDoListItemService.save(toDoListItem);
        }
        helperService.getUser().getToDoList().addItem(toDoListItem);
        toDoListService.save(helperService.getUser().getToDoList());
        coordinatorService.save((Coordinator) helperService.getUser());

    }

    @PostMapping("/schedule")
    public void coordinatorSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (task.isDone()){
            taskService.delete(task);
        }else {
            taskService.save(task);
        }
        helperService.getUser().getSchedule().addItem(task);
        scheduleService.save(helperService.getUser().getSchedule());
        coordinatorService.save((Coordinator) helperService.getUser());
    }

}

