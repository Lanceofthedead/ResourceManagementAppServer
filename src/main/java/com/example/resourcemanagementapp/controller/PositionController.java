package com.example.resourcemanagementapp.controller;

import com.example.resourcemanagementapp.dto.PositionEmployeeDTO;
import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Position;
import com.example.resourcemanagementapp.repository.EmployeeRepository;
import com.example.resourcemanagementapp.repository.PositionRepository;
import com.example.resourcemanagementapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/position")
public class PositionController {


    private PositionRepository positionRepository;


    private PositionService positionService;

    public PositionController(PositionRepository positionRepository, PositionService positionService) {
        this.positionRepository = positionRepository;
        this.positionService = positionService;
    }

    // get all positions
    @GetMapping("/list")
    public Page<Position> positionList(@RequestParam(defaultValue = "0")int page)
    {
        return positionService.positionList(page);
    }

    // get a position
    @GetMapping( value ="/{positionId}")
    public Position getPositionById(@PathVariable("positionId") Long positionId)
    {
        return positionService.getPositionById(positionId);
    }


    // create a position
    @PostMapping(value ="/add")
    public Position createPosition(@RequestBody Position position){
        return positionService.createPosition(position);
    }

    // update a position
    @PutMapping("/update/{positionId}")
    public Position updatePosition(@PathVariable Long positionId, @Valid @RequestBody Position positionRequest){
        return positionService.updatePosition(positionId, positionRequest);
    }

    // delete a position
    @DeleteMapping("/delete/{positionId}")
    public ResponseEntity<?> deletePosition(@PathVariable Long positionId) {
        return positionService.deletePosition(positionId);
    }

//    @GetMapping("position-employee/{positionId}")
//    public PositionEmployeeDTO getPositionEmployee(@PathVariable(value = "positionId") Long positionId) {
//        return positionService.getPositionEmployee(positionId);
//    }

}
