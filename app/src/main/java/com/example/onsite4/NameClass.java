package com.example.onsite4;

public class NameClass {

    public String nameOfFile;
    public String path;
    public boolean subDivision;

    public NameClass(String nameOfFile , String path , boolean subDivision) {
        this.nameOfFile = nameOfFile;
        this.path = path;
        this.subDivision = subDivision;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSubDivision() {
        return subDivision;
    }

    public void setSubDivision(boolean subDivision) {
        this.subDivision = subDivision;
    }
}
