package com.pxlim.ms.routes;

import com.pxlim.ms.model.Note;
import com.pxlim.ms.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
public class Resources {

    Logger logger = LoggerFactory.getLogger(Resources.class);
    @Autowired
    private Service service;

    private Scheduler scheduler;

    @Autowired
    private TaskExecutor executor;

    @PostConstruct
    protected void initializeScheduler() {
        scheduler = Schedulers.from(executor);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public Observable<List<Note>> getNotes() {
        logger.info("get observable");
        Observable<List<Note>> notesObservable = service.getNotesObservable();
        logger.info("return observable");
        return notesObservable.subscribeOn(scheduler);
    }
}
