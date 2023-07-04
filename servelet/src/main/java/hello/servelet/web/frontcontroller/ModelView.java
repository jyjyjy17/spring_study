package hello.servelet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    //MODEL 에 DATA 저장
    //VIEW로 논리 경로 저장
    private String viewName;
    private Map<String,Object> model = new HashMap<>();

    public ModelView(String viewName){
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}