package com.menuorder.demo.service;

import java.util.List;
import java.util.Optional;

import com.menuorder.demo.entity.SampleEntity;
import com.menuorder.demo.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepo;

    public List<SampleEntity> getAll() {
        return sampleRepo.getAll();
    }

    public SampleEntity createSample(SampleEntity sampleEntity) {
        return sampleRepo.save(sampleEntity);
    }

    public SampleEntity updateSample(Long Id, SampleEntity sampleEntity) {
        SampleEntity updatedSample;
        Optional<SampleEntity> searchEntity = sampleRepo.findById(Id);
        if (searchEntity.isPresent()) {
            SampleEntity sample = searchEntity.get();
            sample.setAge(sampleEntity.getAge());
            sample.setName(sampleEntity.getName());
            updatedSample = sampleRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedSample;
    }

    public ResponseEntity<Object> deleteSample(Long Id) {
        Optional<SampleEntity> sampleEntity = sampleRepo.findById(Id);
        if (sampleEntity.isPresent()) {
            SampleEntity sample = sampleEntity.get();
            sampleRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
