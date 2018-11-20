package com.example.resourcemanagementapp.service;

import com.example.resourcemanagementapp.dto.PositionEmployeeDTO;
import com.example.resourcemanagementapp.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PositionService {

    Page<Position> positionList(@RequestParam(defaultValue = "0") int page);

    public Position getPositionById(Long id);

    public Position createPosition(Position position);


    public Position updatePosition(Long positionId, Position positionRequest);

    public ResponseEntity<?> deletePosition(Long positionId);

//    public PositionEmployeeDTO getPositionEmployee(Long positionId);

}


