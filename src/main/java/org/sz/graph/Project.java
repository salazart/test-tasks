package org.sz.graph;

import java.util.*;

public class Project {
    private String name;
    private List<Package> packages = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public Boolean hasCyclicDependencies() {
        return checkPackages(packages, new HashSet<>());
    }

    private boolean checkPackages(List<Package> packages, Set<Package> unique) {
        for (Package p : packages) {
            if (unique.contains(p)) {
                return true;
            } else {
                Set<Package> newUnique = new HashSet<>(unique);
                newUnique.add(p);
                return checkPackages(p.getDependencies(), newUnique);
            }
        }
        return false;
    }

    public List<Package> getCompilationOrder() {
        Set<Package> set = processPackages(packages, new LinkedHashSet<>());
        List<Package> reversedPackages = new LinkedList<>(set);
        Collections.reverse(reversedPackages);
        return reversedPackages;
    }

    private Set<Package> processPackages(List<Package> packages, Set<Package> set) {
        for (Package p : packages) {
            set.remove(p);
            set.add(p);
            set = processPackages(p.getDependencies(), set);
        }
        return set;
    }

    public void addDependency(Package p) {
        this.packages.add(p);
    }
}