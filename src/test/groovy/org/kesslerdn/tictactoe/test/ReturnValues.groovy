package org.kesslerdn.tictactoe.test


class ReturnValues<T> implements Iterator<T> {

	private List<T> values
	private Iterator<T> valuesIterator
	
	ReturnValues(List<T> values){
		this.values = new ArrayList<T>(values)
		valuesIterator = this.values.iterator()
	}
	
	@Override
	boolean hasNext() {
		valuesIterator.hasNext()
	}

	@Override
	T next() {
		valuesIterator.next()
	}

	@Override
	void remove() {
		throw new IllegalAccessException()
	}
}
