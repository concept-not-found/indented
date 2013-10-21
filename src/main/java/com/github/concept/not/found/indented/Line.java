package com.github.concept.not.found.indented;

/**
 * A Line at a certian indent level and with some text.
 */
public class Line {

	/**
	 * The indent level.
	 */
	public final int level;

	/**
	 * The text.
	 */
	public final String text;

	/**
	 * Creates a new Line.
	 * @param level the indent level
	 * @param text the text
	 */
	public Line(final int level, final String text) {
		this.level = level;
		this.text = text;
	}
}
