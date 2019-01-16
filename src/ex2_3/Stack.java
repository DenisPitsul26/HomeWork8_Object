package ex2_3;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private List<Object> objectList;
    private BlackList blackList;

    public Stack(BlackList blackList) {
        objectList = new ArrayList<>();
        this.blackList = blackList;
    }

    public Stack() {
        objectList = new ArrayList<>();
        blackList = new BlackList();
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public BlackList getBlackList() {
        return blackList;
    }

    public void setBlackList(BlackList blackList) {
        this.blackList = blackList;
    }

    public void addObject(Object object) {
        if (isObjectAlreadyInTheList(object) || blackList.isClassAlreadyInTheList(object.getClass()))
            System.out.println("This object can not add to stack.");
        else
            objectList.add(object);
    }

    public Object getAndDeleteObject() {
        Object object = objectList.get(objectList.size()-1);
        objectList.remove(objectList.size()-1);
        return object;
    }

    public Object getObject() {
        return objectList.get(objectList.size()-1);
    }

    private boolean isObjectAlreadyInTheList(Object object){
        for (Object aObjectList : objectList) {
            if (aObjectList.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "objectList=" + objectList +
                ", blackList=" + blackList +
                '}';
    }
}
