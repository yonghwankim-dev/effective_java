package role8.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class CrashedFinalizable {
    public static void main(String[] args) throws ReflectiveOperationException, InterruptedException {
        for (int i = 0; ; i++) {
            new CrashedFinalizable();
            
            if ((i % 1_000_000) == 0) {
                Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
                Field queueStaticField = finalizerClass.getDeclaredField("queue"); // Finalizer Ŭ������ queue �ʵ����� ������
                queueStaticField.setAccessible(true); // queue�� �������
                ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);

                Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength"); // ť�� ���� �ʵ��� ������
                queueLengthField.setAccessible(true); // ��� ���� ���
                long queueLength = (long) queueLengthField.get(referenceQueue); // ���� ������� �ν��Ͻ��� ������ ����
                System.out.format("There are %d references in the queue%n", queueLength);
            }
        }
    }

    @Override
    protected void finalize() {
        System.out.print("");
    }
}