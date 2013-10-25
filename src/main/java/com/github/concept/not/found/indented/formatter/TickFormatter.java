package com.github.concept.not.found.indented.formatter;

import com.github.concept.not.found.indented.Line;
import com.github.concept.not.found.indented.Paragraph;
import com.github.concept.not.found.indented.ParagraphFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * Formats the Paragraph into plain text with a given tick for each indent level.
 */
public class TickFormatter implements ParagraphFormatter {

	private final String tick;

	/**
	 * Constructor.
	 * @param tick the tick in front of each line
	 */
	public TickFormatter(final String tick) {
		this.tick = tick;
	}

	@Override
	public String format(final Paragraph paragraph) {
		StringBuilder result = new StringBuilder();
		for (Line line : paragraph) {
			result.append(StringUtils.repeat(tick, line.level));
			result.append(line.text);
			result.append("\n");
		}
		return result.toString();
	}

}
