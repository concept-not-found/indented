package com.github.concept.not.found.indented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Paragraph implements Iterable<Line> {

	private int level = 0;
	private List<Line> lines = new ArrayList<Line>();

	public void append(final String text) {
		lines.add(new Line(level, text));
	}

	public void indent() {
		level++;
	}

	public void unindent() {
		level--;
	}

	@Override
	public Iterator<Line> iterator() {
		return getLines().iterator();
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
