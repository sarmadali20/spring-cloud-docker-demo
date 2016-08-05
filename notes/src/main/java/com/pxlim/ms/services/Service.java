package com.pxlim.ms.services;

import com.pxlim.ms.model.Note;
import rx.Observable;

import java.util.List;

public interface Service {

    public Observable<List<Note>> getNotesObservable();
}
