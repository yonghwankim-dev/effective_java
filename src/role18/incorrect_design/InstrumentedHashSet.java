package role18.incorrect_design;

import java.util.Collection;
import java.util.HashSet;

/**
 * title : 잘못된 하위 클래스 설계
 * content : InstrumentedHashSet 클래스는 HashSet 인스턴스가
 * 처음 생성된 이후 원소가 몇 개 더해졌는지 알 수 있는 클래스
 * @param <E> : HashSet 컬렉션에 들어갈 원소 타입
 */

class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
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
