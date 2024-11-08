package ru.ssau.tk.shnurok.lab2.concurrent;

import ru.ssau.tk.shnurok.lab2.functions.coredefenitions.TabulatedFunction;
import ru.ssau.tk.shnurok.lab2.functions.realizations.Point;
import ru.ssau.tk.shnurok.lab2.operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction function;

    public SynchronizedTabulatedFunction(TabulatedFunction function) {
        this.function = function;
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction function);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (this) {
            return operation.apply(this);
        }
    }

    @Override
    public synchronized int getCount() {
        return function.getCount();
    }

    @Override
    public synchronized double getX(int index) {
        return function.getX(index);
    }

    @Override
    public synchronized double getY(int index) {
        return function.getY(index);
    }

    @Override
    public synchronized void setY(int index, double value) {
        function.setY(index, value);
    }

    @Override
    public synchronized int indexOfX(double x) {
        return function.indexOfX(x);
    }

    @Override
    public synchronized int indexOfY(double y) {
        return function.indexOfY(y);
    }

    @Override
    public synchronized double leftBound() {
        return function.leftBound();
    }

    @Override
    public synchronized double rightBound() {
        return function.rightBound();
    }

    @Override
    public synchronized Iterator<Point> iterator() {
        synchronized (function) {
            Point[] points = TabulatedFunctionOperationService.asPoints(function);
            return new Iterator<Point>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < points.length;
                }

                @Override
                public Point next() {
                    if (!hasNext())
                        throw new NoSuchElementException();

                    return points[i++];
                }
            };
        }

    }

    @Override
    public synchronized double apply(double x) {
        return function.apply(x);
    }
}
