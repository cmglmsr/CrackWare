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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping({"fbm", "/fbm"})
public class FacultyBoardMemberController {

    private final HelperService helperService;

    private final FacultyBoardMemberService facultyBoardMemberService;

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    private final ToDoListItemService toDoListItemService;

    private final ScheduleService scheduleService;

    private final DocumentService documentService;

    public FacultyBoardMemberController(HelperService helperService, FacultyBoardMemberService facultyBoardMemberService, ToDoListService toDoListService, TaskService taskService, ToDoListItemService toDoListItemService, ScheduleService scheduleService, DocumentService documentService) {
        this.helperService = helperService;
        this.facultyBoardMemberService = facultyBoardMemberService;
        this.toDoListService = toDoListService;
        this.taskService = taskService;
        this.toDoListItemService = toDoListItemService;
        this.scheduleService = scheduleService;
        this.documentService = documentService;
    }

    @GetMapping("/home")
    public FacultyBoardMember facultyBoardMemberHome() {
        return (FacultyBoardMember) helperService.getUser();
    }
    @GetMapping("/profile")
    public FacultyBoardMember facultyBoardMemberProfile() {
        return (FacultyBoardMember) helperService.getUser();
    }

    @PostMapping("/todolist")
    public void fbmToDoList(@Valid @RequestBody ToDoRequest toDoRequest){
        ToDoListItem toDoListItem = ToDoListHelper.toDoListHelp(toDoRequest);
        if (helperService.getUser().getToDoList() == null){
            helperService.getUser().setToDoList(new ToDoList());
        }
        if (toDoListItem.isDone()){
            toDoListItemService.deleteAllByDescriptionAndDueDate(toDoListItem.getDescription(),
                    toDoRequest.getDueDate());
        }else {
            toDoListItemService.save(toDoListItem);
            if (helperService.getUser().getToDoList() != null)
                helperService.getUser().getToDoList().addItem(toDoListItem);
            else {
                helperService.getUser().setToDoList(new ToDoList());
                helperService.getUser().getToDoList().addItem(toDoListItem);
            }
            toDoListService.save(helperService.getUser().getToDoList());
            facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());
        }


    }

    @PostMapping("/schedule")
    public void fbmSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest){
        Task task = ScheduleHelper.scheduleHelp(scheduleRequest);
        if (helperService.getUser().getSchedule() == null){
            helperService.getUser().setSchedule(new Schedule());
        }
        if (task.isDone()){
            taskService.deleteAllByDescriptionAndDueDate(scheduleRequest.getDescription(),
                    scheduleRequest.getDueDate());
        }else {
            taskService.save(task);
            if (helperService.getUser().getSchedule() != null)
                helperService.getUser().getSchedule().addItem(task);
            else {
                helperService.getUser().setSchedule(new Schedule());
                helperService.getUser().getSchedule().addItem(task);
            }
            scheduleService.save(helperService.getUser().getSchedule());
            facultyBoardMemberService.save((FacultyBoardMember) helperService.getUser());
        }


    }

    @PostMapping("/preapproval/approve/{id}")
    public void approvePreApproval(@PathVariable String id){
        Document document = documentService.findById(Long.valueOf(id));
        document.setDocumentStatus(Status.APPROVED);
        documentService.save(document);

    }


    @PostMapping("/preapproval/reject{id}")
    public void rejectPreApproval(@PathVariable String id){
        Document document = documentService.findById(Long.valueOf(id));
        document.setDocumentStatus(Status.DENIED);
        documentService.save(document);
    }

    @GetMapping("/preapprovals")
    public Set<Document> preApprovals(){
        ArrayList<Document> documents = new ArrayList<>(documentService.findAll());
        HashSet<Document> learningAgreements = new HashSet<>();
        for (Document document : documents) {
            if (document.getType() == "preApproval") {
                learningAgreements.add(document);
            }
        }
        return learningAgreements;
    }



}