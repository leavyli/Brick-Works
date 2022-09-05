package com.example.mall.admin.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author saino
 * Create 12:00
 */
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "turorialDemo")
@ToString
public class TutorialDemo {
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private Boolean published;
}
