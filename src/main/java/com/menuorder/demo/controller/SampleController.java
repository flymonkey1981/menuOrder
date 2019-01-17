package com.menuorder.demo.controller;

import java.util.List;

import com.menuorder.demo.entity.SampleEntity;
import com.menuorder.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class SampleController {

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/sample")
    public List<SampleEntity> sample() {
        return sampleService.getAll();
    }

    @RequestMapping(value = "/createsample", method = RequestMethod.POST)
    public SampleEntity createSample(@Valid @RequestBody SampleEntity sampleEntity) {
        return sampleService.createSample(sampleEntity);
    }

    @RequestMapping(value = "/deletesample/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") Long id) {
        return sampleService.deleteSample(id);
    }

    @RequestMapping(value = "/updatesample/{id}", method = RequestMethod.PUT)
    public SampleEntity updateSample(@PathVariable(value = "id") Long id,
                                     @Valid @RequestBody SampleEntity sampleEntity) {
        return sampleService.updateSample(id, sampleEntity);
    }
}
