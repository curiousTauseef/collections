/*******************************************************************************
 * BEGIN COPYRIGHT NOTICE
 * 
 * This file is part of program "Collections"
 * Copyright 2011  Rodrigo Lemos
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * END COPYRIGHT NOTICE
 ******************************************************************************/
package br.eti.rslemos.tools.collections;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public abstract class PackedArrayUnitTest {

	protected abstract PackedArray<String> createStringArray(int... sizes);

	@Test
	public void testOneDimensionalUnitArray() {
		PackedArray<String> array = createStringArray(6);
		
		// storage
		array.set("[0]", 0);
		array.set("[1]", 1);
		array.set("[2]", 2);
		array.set("[3]", 3);
		array.set("[4]", 4);
		array.set("[5]", 5);
		
		assertThat(array.get(0), is(equalTo("[0]")));
		assertThat(array.get(1), is(equalTo("[1]")));
		assertThat(array.get(2), is(equalTo("[2]")));
		assertThat(array.get(3), is(equalTo("[3]")));
		assertThat(array.get(4), is(equalTo("[4]")));
		assertThat(array.get(5), is(equalTo("[5]")));
		
		// boundary check
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array, -1);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  6);
		
		accessAndExpectException(IllegalArgumentException.class, array);
		accessAndExpectException(IllegalArgumentException.class, array, 0, 0);
		accessAndExpectException(IllegalArgumentException.class, array, 0, 0, 0);
	}
	
	@Test
	public void testTwoDimensionalUnitArray() {
		PackedArray<String> array = createStringArray(3, 3);

		// storage
		array.set("[0, 0]", 0, 0);
		array.set("[0, 1]", 0, 1);
		array.set("[0, 2]", 0, 2);
		array.set("[1, 0]", 1, 0);
		array.set("[1, 1]", 1, 1);
		array.set("[1, 2]", 1, 2);
		array.set("[2, 0]", 2, 0);
		array.set("[2, 1]", 2, 1);
		array.set("[2, 2]", 2, 2);
		
		assertThat(array.get(0, 0), is(equalTo("[0, 0]")));
		assertThat(array.get(0, 1), is(equalTo("[0, 1]")));
		assertThat(array.get(0, 2), is(equalTo("[0, 2]")));
		assertThat(array.get(1, 0), is(equalTo("[1, 0]")));
		assertThat(array.get(1, 1), is(equalTo("[1, 1]")));
		assertThat(array.get(1, 2), is(equalTo("[1, 2]")));
		assertThat(array.get(2, 0), is(equalTo("[2, 0]")));
		assertThat(array.get(2, 1), is(equalTo("[2, 1]")));
		assertThat(array.get(2, 2), is(equalTo("[2, 2]")));
		
		// boundary check
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0, -1);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array, -1,  0);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0,  3);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  3,  0);
		
		accessAndExpectException(IllegalArgumentException.class, array);
		accessAndExpectException(IllegalArgumentException.class, array, 0);
		accessAndExpectException(IllegalArgumentException.class, array, 0, 0, 0);
	}

	@Test
	public void testThreeDimensionalUnitArray() {
		PackedArray<String> array = createStringArray(2, 2, 2);

		// storage
		array.set("[0, 0, 0]", 0, 0, 0);
		array.set("[0, 0, 1]", 0, 0, 1);
		array.set("[0, 1, 0]", 0, 1, 0);
		array.set("[0, 1, 1]", 0, 1, 1);
		array.set("[1, 0, 0]", 1, 0, 0);
		array.set("[1, 0, 1]", 1, 0, 1);
		array.set("[1, 1, 0]", 1, 1, 0);
		array.set("[1, 1, 1]", 1, 1, 1);
		
		assertThat(array.get(0, 0, 0), is(equalTo("[0, 0, 0]")));
		assertThat(array.get(0, 0, 1), is(equalTo("[0, 0, 1]")));
		assertThat(array.get(0, 1, 0), is(equalTo("[0, 1, 0]")));
		assertThat(array.get(0, 1, 1), is(equalTo("[0, 1, 1]")));
		assertThat(array.get(1, 0, 0), is(equalTo("[1, 0, 0]")));
		assertThat(array.get(1, 0, 1), is(equalTo("[1, 0, 1]")));
		assertThat(array.get(1, 1, 0), is(equalTo("[1, 1, 0]")));
		assertThat(array.get(1, 1, 1), is(equalTo("[1, 1, 1]")));
		
		// boundary check
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0,  0, -1);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0, -1,  0);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array, -1,  0,  0);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0,  0,  3);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  0,  3,  0);
		accessAndExpectException(ArrayIndexOutOfBoundsException.class, array,  3,  0,  0);
		
		accessAndExpectException(IllegalArgumentException.class, array);
		accessAndExpectException(IllegalArgumentException.class, array, 0);
		accessAndExpectException(IllegalArgumentException.class, array, 0, 0);
	}

	private static <E extends RuntimeException> void accessAndExpectException(Class<E> clazz, PackedArray<String> array, int... pos) {
		getAndExpectException(clazz, array, pos);
		setAndExpectException(clazz, array, pos);
	}

	private static <E extends RuntimeException> void setAndExpectException(Class<E> clazz, PackedArray<String> array, int... pos) {
		try {
			array.set(null, pos);
			fail("Should have thrown " + clazz);
		} catch (RuntimeException expected) {
			if (!clazz.isInstance(expected))
				throw expected;
		}
	}

	private static <E extends RuntimeException> void getAndExpectException(Class<E> clazz, PackedArray<String> array, int... pos) {
		try {
			array.get(pos);
			fail("Should have thrown " + clazz);
		} catch (RuntimeException expected) {
			if (!clazz.isInstance(expected))
				throw expected;
		}
	}
}