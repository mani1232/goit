package ua.mani123.module11;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Utils {


    public static <E> List<Object> oddList(List<E> list, boolean addIndexes) {
        return IntStream.range(0, list.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> {
                    if (addIndexes) {
                        return index + ". " + list.get(index);
                    } else {
                        return list.get(index);
                    }
                }).collect(Collectors.toList());
    }

    public static Stream<Long> generateRandomStream(long a, long c, long m) {
        return Stream.iterate(System.currentTimeMillis(), x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() || secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (firstIterator.hasNext()) {
                    T nextFromFirst = firstIterator.next();
                    if (secondIterator.hasNext()) {
                        return secondIterator.next();
                    } else {
                        return nextFromFirst;
                    }
                } else {
                    return secondIterator.next();
                }
            }
        };
        Spliterator<T> zippedSpliterator = Spliterators.spliteratorUnknownSize(zippedIterator, 0);
        return StreamSupport.stream(zippedSpliterator, false);
    }

}
