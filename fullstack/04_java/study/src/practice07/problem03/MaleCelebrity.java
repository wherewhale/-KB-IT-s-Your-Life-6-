package practice07.problem03;

import practice07.problem02.Celebrity;

public class MaleCelebrity implements Celebrity {
    private String name;

    MaleCelebrity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MaleCelebrity that)) return false;
        return getName().equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "남자 연예인: " + name;
    }
}
