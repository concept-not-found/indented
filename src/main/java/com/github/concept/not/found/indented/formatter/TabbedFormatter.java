package com.github.concept.not.found.indented.formatter;

import com.github.concept.not.found.indented.Line;
import com.github.concept.not.found.indented.Paragraph;
import com.github.concept.not.found.indented.ParagraphFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * Formats the Paragraph into plain text tabbed for each indent level.
 */
public class TabbedFormatter implements ParagraphFormatter {

	@Override
	public String format(final Paragraph paragraph) {
		StringBuilder result = new StringBuilder();
		for (Line line : paragraph) {
			result.append(StringUtils.repeat("\t", line.level));
			result.append(line.text);
			result.append("\n");
		}
		return result.toString();
	}

}
