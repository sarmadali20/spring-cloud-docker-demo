package com.pxlim.ms.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.pxlim.ms.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;

    public List<Note> getNotes() {
        logger.info("Making network request");
        ResponseEntity<List<Note>> responseEntity = restTemplate.exchange("http://private-a0c0d-dummy8.apiary-mock.com/notes", HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>() {
        });
        return responseEntity.getBody();
    }

    @HystrixCommand(commandKey = "getNotesObservable", fallbackMethod = "getNotesObservableFallback", observableExecutionMode = ObservableExecutionMode.LAZY)
    public Observable<List<Note>> getNotesObservable() {
        return Observable.create(new Observable.OnSubscribe<List<Note>>() {
            @Override
            public void call(Subscriber<? super List<Note>> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        observer.onNext(getNotes());
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }

    public Observable<List<Note>> getNotesObservableFallback() {
        return Observable.just(new ArrayList<Note>());

    }
}
