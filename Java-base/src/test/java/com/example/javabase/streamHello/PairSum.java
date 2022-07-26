package com.example.javabase.streamHello;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Author saino
 * LastModify 18:43
 */

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class PairSum<F, S> {
    private final F first;
    private final S second;
}
