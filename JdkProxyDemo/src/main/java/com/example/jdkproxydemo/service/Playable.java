package com.example.jdkproxydemo.service;

import java.io.File;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/5 13:48
 */
public interface Playable {
    String play(String song);

    String play(File song);

    String play(File song, int start);

    String play(File song, int start, int finish);

}
