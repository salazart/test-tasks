package org.sz.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProjectTest {

    @Test
    public void testHasCyclicDependencies() {
        Package a = new Package("A");
        Package b = new Package("B");
        Package c = new Package("C");
        a.addDependency(b);
        b.addDependency(c);
        c.addDependency(a);

        Project project = new Project("project1");
        project.addDependency(a);

        assertThat(project.hasCyclicDependencies(), is(true));
    }

    @Test
    public void testGetCompilationOrder() {
        Package a = new Package("A");
        Package b = new Package("B");
        Package c = new Package("C");
        Package d = new Package("D");
        Package e = new Package("E");

        e.addDependency(d);
        d.addDependency(c);
        c.addDependency(b);
        a.addDependency(d);

        Project project = new Project("project1");
        project.addDependency(e);
        project.addDependency(a);

        List<Package> expectedPackages = Arrays.asList(b, c, d, a, e);
        assertThat(project.getCompilationOrder(), is(expectedPackages));
    }
}