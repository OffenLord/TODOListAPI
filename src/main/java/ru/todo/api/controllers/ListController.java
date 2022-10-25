package ru.todo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.todo.api.list.Position;
import ru.todo.api.services.ListService;

import java.util.ArrayList;

@RestController
public class ListController {

    private final ListService listService;

    @Autowired
    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping(value = "/list")
    public ResponseEntity<?> addPosition(@RequestBody Position position) {
        listService.addPosition(position);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ArrayList<Position>> getPosition() {
        ArrayList<Position> positions = listService.getPositions();
        if (positions != null) return new ResponseEntity<>(positions, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable(name = "id") int id) {
        Position position = listService.getPositionById(id);
        if (position != null) return new ResponseEntity<>(position, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/list/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable(name = "id") int id) {
        Position position = listService.getPositionById(id);
        if (position != null) {
            position.updateCheck();
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/list/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable(name = "id") int id) {
        if (listService.deletePosition(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
