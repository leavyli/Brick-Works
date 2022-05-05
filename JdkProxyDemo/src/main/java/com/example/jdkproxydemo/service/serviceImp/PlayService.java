package com.example.jdkproxydemo.service.serviceImp;

import com.example.jdkproxydemo.annotations.MyCustomTransaction;
import com.example.jdkproxydemo.annotations.TransactionalService;
import com.example.jdkproxydemo.service.Playable;
import com.example.jdkproxydemo.service.Seekable;

import java.io.File;

@TransactionalService
public class PlayService implements Playable, Seekable {
    @Override
    public String play(String song) {
        return "Playing song " + song;
    }

    @Override
    @MyCustomTransaction("file")
    public String play(File song) {
        return "Playing song " + song.getName();
    }

    @Override
    @MyCustomTransaction("starting at")
    public String play(File song, int start) {
        return "Playing song " + song.getName() + " start at " + start;
    }

    @Override
    @MyCustomTransaction("interval")
    public String play(File song, int start, int finish) {
        return "Playing song " + song.getName() + " start at " + start + " finish at " + finish;
    }

    @Override
    public String seekTo(int position) {
        return "Seeking to " + position;
    }
}
