/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 Sri Harsha Chilakapati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.componentSystem.borrowed;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sri Harsha Chilakapati
 */
class ComponentType
{
    private static final Map<Class<? extends Component>, ComponentType> componentTypes = new HashMap<>();

    private static int typeIndex = 0;

    private int index;

    private ComponentType()
    {
        this.index = typeIndex++;
    }

    static ComponentType of(Class<? extends Component> klass)
    {
        ComponentType cType = componentTypes.get(klass);

        if (cType == null)
            componentTypes.put(klass, cType = new ComponentType());

        return cType;
    }

    boolean equals(ComponentType other)
    {
        return this.index == other.index;
    }

    public int getIndex()
    {
        return index;
    }
}
