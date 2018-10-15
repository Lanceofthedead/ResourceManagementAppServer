package com.example.resourcemanagementapp.service.impl;

import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Position;
import com.example.resourcemanagementapp.repository.PositionRepository;
import com.example.resourcemanagementapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> positionList() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(@PathVariable("positionId") Long positionId)
    {
        return positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("PositionId" + positionId + " not Found"));
    }


    @Override
    public Position createPosition(@RequestBody Position position){
        return positionRepository.save(position);
    }


    @Override
    public Position updatePosition(@PathVariable Long positionId, @Valid @RequestBody Position positionRequest) {
        positionRequest.setPositionId(positionId);
        return positionRepository.save(positionRequest);
    }




    @Override
    public ResponseEntity<?> deletePosition(@PathVariable Long positionId) {
        return positionRepository.findById(positionId).map(position -> {
            positionRepository.delete(position);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PositionId " + positionId + " not found"));
    }

}
