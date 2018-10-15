package com.example.resourcemanagementapp.service;

import com.example.resourcemanagementapp.model.Position;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionService {

    List<Position> positionList();

    public Position getPositionById(Long id);

    public Position createPosition(Position position);


    public Position updatePosition(Long positionId, Position positionRequest);

    public ResponseEntity<?> deletePosition(Long positionId);
}


