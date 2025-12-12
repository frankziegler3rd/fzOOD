/**
 * OOD, professor chu
 * final exam
 *
 * generic chart collection interface
 *
 * @author frank ziegler
 * @version 1
 */

package service;

public interface ChartCollection {
    
    /**
     * all collection classes must have an associated iterator method and their data must not be iterable directly.
     */
    ChartIterator iterator();
}
