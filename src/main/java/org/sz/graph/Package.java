package org.sz.graph;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private String name;
    private List<Package> dependencies = new ArrayList<>();

    public Package(String name) {
        this.name = name;
    }

    public List<Package> getDependencies() {
        return dependencies;
    }

    public void addDependency(Package p) {
        this.dependencies.add(p);
    }

    public  String getName() {
        return name;
    }
}