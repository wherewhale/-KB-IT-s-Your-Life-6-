package org.scoula.ex06;

import org.scoula.ex06.command.Command;

import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;
    String prefix = "/views/";
    String suffix = ".jsp";
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
    }


}
