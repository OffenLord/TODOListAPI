package ru.todo.api.list;

public class Position {

    private int id;
    private String text = "";
    private boolean checked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void updateCheck() {
        this.checked = !this.checked;
    }
}
