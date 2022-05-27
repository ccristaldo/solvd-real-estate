package generics.apt;

import java.util.HashSet;
import java.util.Iterator;

public class EnumAptGeneric<T> implements Iterable{
    HashSet<T> aptSet = new HashSet<>();

    public void add(T ob){
        aptSet.add(ob);
    }
    
    @Override
    public Iterator iterator() {
        return aptSet.iterator();
    }

    public boolean isEmpty() {
        return aptSet.isEmpty();
    }
}
