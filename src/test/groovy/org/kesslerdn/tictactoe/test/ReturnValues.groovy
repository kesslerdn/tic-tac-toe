package org.kesslerdn.tictactoe.test


class ReturnValues<T> implements Iterator<T> {

	private List<T> values
	private Iterator<T> valuesIterator
	
	ReturnValues(List<T> values){
		this.values = new ArrayList<T>(values)
		valuesIterator = this.values.iterator()
	}
	
	@Override
	public boolean hasNext() {
		valuesIterator.hasNext()
	}

	@Override
	public T next() {
		valuesIterator.next()
	}

	@Override
	public void remove() {
		throw new IllegalAccessException()
	}
}
