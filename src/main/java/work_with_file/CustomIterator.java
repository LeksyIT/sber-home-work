package work_with_file;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomIterator<T> implements Iterable<T>{

    private final List<T> data;
    public CustomIterator(List<T> list){
        this.data = list;
    }

    @Override
    public Iterator<T> iterator() {
        final ListIterator<T> iterator = data.listIterator(data.size());
        return new Iterator<>(){
            @Override
            public T next(){
                return iterator.previous();
            }
            @Override
            public boolean hasNext(){
                return iterator.hasPrevious();
            }
        };
    }
}
