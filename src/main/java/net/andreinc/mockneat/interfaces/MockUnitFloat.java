package net.andreinc.mockneat.interfaces;

/**
 * Copyright 2017, Andrei N. Ciobanu

 Permission is hereby granted, free of charge, to any user obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, FREE_TEXT OF OR PARAM CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS PARAM THE SOFTWARE.
 */

import java.util.function.Supplier;
import java.util.stream.DoubleStream;

import static java.util.stream.DoubleStream.generate;
import static java.util.stream.IntStream.range;
import static net.andreinc.mockneat.utils.ValidationUtils.SIZE_BIGGER_THAN_ZERO;
import static net.andreinc.mockneat.utils.ValidationUtils.isTrue;

//TODO add it in documentation
public interface MockUnitFloat extends MockUnit<Float> {

    default MockUnit<DoubleStream> doubleStream() {
        Supplier<DoubleStream> supp = () -> generate(supplier()::get);
        return () -> supp;
    }

    default MockUnit<float[]> arrayPrimitive(int size) {
        isTrue(size>=0, SIZE_BIGGER_THAN_ZERO);
        Supplier<float[]> supp = () -> {
            final float[] result = new float[size];
            range(0, size).forEach(i -> result[i] = val());
            return result;
        };
        return () -> supp;
    }
    default MockUnit<Float[]> array(int size) {
        isTrue(size>=0, SIZE_BIGGER_THAN_ZERO);
        Supplier<Float[]> supp = () -> {
            final Float[] result = new Float[size];
            range(0, size).forEach(i -> result[i] = val());
            return result;
        };
        return () -> supp;
    }
}
