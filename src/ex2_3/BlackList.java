package ex2_3;

import java.util.ArrayList;
import java.util.List;

public class BlackList {

    List<Class> classList;

    public BlackList(List<Class> classList) {
        this.classList = classList;
    }

    public BlackList() {
        classList = new ArrayList<>();
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    public void addClass(Class sameClass){
        if (!isClassAlreadyInTheList(sameClass))
            classList.add(sameClass);
        else
            System.out.println("This class is already in the black list.");
    }

    public void deleteClass(Class sameClass){
        if (isClassAlreadyInTheList(sameClass))
            classList.remove(sameClass);
        else
            System.out.println("Such a class is not in the black list.");
    }

    public boolean isClassAlreadyInTheList(Class sameClass){
        for (Class aClassList : classList) {
            if (aClassList == sameClass) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "classList=" + classList +
                '}';
    }
}
