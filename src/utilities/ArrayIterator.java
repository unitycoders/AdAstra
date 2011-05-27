/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Iterator;

/**
 *
 * @author webpigeon
 */
public class ArrayIterator<T> implements Iterator<T> {
    private T[] values;
    private int cursor;

    public ArrayIterator(T[] v){
        values = v;
        cursor = 0;
    }
    
    @Override
    public boolean hasNext() {
        return values.length > cursor;
    }

    @Override
    public T next() {
        return values[cursor++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
