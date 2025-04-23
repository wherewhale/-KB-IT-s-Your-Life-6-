package practice07.problem05;

import practice07.problem02.Celebrity;

public class FemaleCelebrity implements Celebrity {
    private String name;

    FemaleCelebrity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FemaleCelebrity that)) return false;
        return getName().equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "여자 연예인: " + name;
    }
}
