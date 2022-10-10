package role18.composition_design;

import com.sun.source.tree.Tree;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

public class InstrumentedSetTest {
    @Test
    public void getAddCount(){
        //given
        InstrumentedSet<String>        set   = new InstrumentedSet<>(new HashSet<>());
        InstrumentedSet<LocalDateTime> times = new InstrumentedSet<>(new TreeSet<>());
        //when
        set.addAll(List.of("A","B","C"));
        times.addAll(List.of(LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()));
        int actual1 = set.getAddCount();
        int actual2 = times.getAddCount();
        //then
        assertThat(actual1).isEqualTo(3);
        assertThat(actual2).isEqualTo(3);
    }
}