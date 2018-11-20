package com.example.resourcemanagementapp.service.impl;

import com.example.resourcemanagementapp.dto.PositionEmployeeDTO;
import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Position;
import com.example.resourcemanagementapp.repository.PositionRepository;
import com.example.resourcemanagementapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Page<Position> positionList(@RequestParam(defaultValue = "0") int page) {
        return positionRepository.findAll(new PageRequest(page, 5));
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

//    @Override
//    public PositionEmployeeDTO getPositionEmployee(@PathVariable(value = "positionId") Long positionId) {
//            Position position = positionRepository.findById(positionId)
//                    .orElseThrow(() -> new ResourceNotFoundException("PositionId" + positionId + " not Found"));
//            PositionEmployeeDTO positionEmployeeDTO;
//            return new PositionEmployeeDTO(position.getJobTitle(), position.getEmployees());
//        }
    }



