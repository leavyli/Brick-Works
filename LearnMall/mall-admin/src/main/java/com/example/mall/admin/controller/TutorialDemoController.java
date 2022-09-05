package com.example.mall.admin.controller;

import com.example.mall.admin.common.api.CommonResult;
import com.example.mall.admin.model.TutorialDemo;
import com.example.mall.admin.repository.TutorialDemoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author saino
 * Create 2022/9/5 12:22
 */

@Tag(name = "TutorialDemoController", description = "TutorialDemo 相关接口")
@RestController
@RequestMapping("/test/turodemo")
@RequiredArgsConstructor
public class TutorialDemoController {
    private  final TutorialDemoRepository repository;

    @PostMapping("/create")
    public CommonResult createTutorialDemo(@RequestBody TutorialDemo demo) {
        repository.save(new TutorialDemo(demo.getTitle(), demo.getDescription(), demo.getPublished()));
        return CommonResult.success("save success");
    }


}
