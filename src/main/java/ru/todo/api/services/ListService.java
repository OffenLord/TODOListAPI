package ru.todo.api.services;

import org.springframework.stereotype.Service;
import ru.todo.api.list.Position;

import java.util.ArrayList;

@Service
public class ListService {

    private static final ArrayList<Position> positions = new ArrayList<>();

    public void addPosition(Position position) {
        int id = positions.size();
        position.setId(id);
        positions.add(position);
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public Position getPositionById(int id) {
        return positions.get(id);
    }

    public void updateCheck(int id) {
        positions.get(id).updateCheck();
    }

    public boolean deletePosition(int id) {
        return positions.remove(id) != null;
    }
}
