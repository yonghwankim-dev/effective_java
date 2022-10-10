package role18.incorrect_design;

import java.util.Collection;
import java.util.HashSet;

/**
 * title : �߸��� ���� Ŭ���� ����
 * content : InstrumentedHashSet Ŭ������ HashSet �ν��Ͻ���
 * ó�� ������ ���� ���Ұ� �� �� ���������� �� �� �ִ� Ŭ����
 * @param <E> : HashSet �÷��ǿ� �� ���� Ÿ��
 */

class InstrumentedHashSet<E> extends HashSet<E> {
    // �߰��� ������ ��
    private int addCount;

    public InstrumentedHashSet(){
        this.addCount = 0;
    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor){
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
//        addCount += c.size();
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public boolean addElement(E e){
        addCount++;
        return super.add(e);
    }

    public boolean addAllElements(Collection<? extends E> c){
        boolean modified = false;
        for (E e : c)
            if (addElement(e))
                modified = true;
        return modified;
    }

    public int getAddCount(){
        return addCount;
    }
}
