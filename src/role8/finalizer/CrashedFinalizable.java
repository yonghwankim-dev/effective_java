package role8.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class CrashedFinalizable {
    public static void main(String[] args) throws ReflectiveOperationException, InterruptedException {
        for (int i = 0; ; i++) {
            new CrashedFinalizable();
            
            if ((i % 1_000_000) == 0) {
                Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
                Field queueStaticField = finalizerClass.getDeclaredField("queue"); // Finalizer 클래스에 queue 필드멤버를 가져옴
                queueStaticField.setAccessible(true); // queue에 접근허용
                ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);

                Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength"); // 큐의 길이 필드멤버 가져옴
                queueLengthField.setAccessible(true); // 멤버 접근 허용
                long queueLength = (long) queueLengthField.get(referenceQueue); // 삭제 대기중인 인스턴스의 개수를 참조
                System.out.format("There are %d references in the queue%n", queueLength);
            }
        }
    }

    @Override
    protected void finalize() {
        System.out.print("");
    }
}