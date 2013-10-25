package com.github.concept.not.found.indented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

/**
 * A Paragraph consists of Lines which may be indented.
 */
public class Paragraph implements Iterable<Line> {

	private int level = 0;
	private List<Line> lines = new ArrayList<Line>();

	/**
	 * Adds a line at the current indent level.
	 * @param text the text for the line
	 */
	public void append(final String text) {
		lines.add(new Line(level, text));
	}

	/**
	 * Appends with String.format(..).
	 * @param format the format for String.format(..)
	 * @param args the args for String.format(..)
	 */
	public void append(final String format, final Object... args) {
		append(String.format(format, args));
	}

	/**
	 * Appends ObjectUtils.toString(..)
	 * @param object the object to convert to String
	 */
	public void append(final Object object) {
		append(ObjectUtils.toString(object));
	}

	/**
	 * All subsequent appended text will be indented one level deeper.
	 */
	public void indent() {
		level++;
	}

	/**
	 * All subsequent appended text will be indented one level shallower.
	 */
	public void unindent() {
		level--;
	}

	@Override
	public Iterator<Line> iterator() {
		return getLines().iterator();
	}

	/**
	 * All the lines in this paragraph.
	 * @return the lines
	 */
	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
