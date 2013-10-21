package com.github.concept.not.found.indented.formatter;

import java.util.ArrayList;
import java.util.List;

import com.github.concept.not.found.indented.Line;
import com.github.concept.not.found.indented.Paragraph;
import com.github.concept.not.found.indented.ParagraphFormatter;

/**
 * Formats the Paragraph into an unordered HTML list snippet.
 *
 * Indented lines will be nested unordered HTML lists.
 */
public class HtmlListFormatter implements ParagraphFormatter {

	@Override
	public String format(final Paragraph paragraph) {
		return format(paragraph.getLines(), 0);
	}

	private String format(final List<Line> lines, final int level) {
		if (lines.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		result.append("<ul>");
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			if (line.level == level) {
				result.append("<li>");
				result.append(line.text);
				List<Line> nextLevel = collectNextLevel(lines.subList(i + 1, lines.size()), level);
				result.append(format(nextLevel, level + 1));
				i += nextLevel.size();
				result.append("</li>");
			}
		}
		result.append("</ul>");
		return result.toString();
	}

	private List<Line> collectNextLevel(final List<Line> lines, final int level) {
		List<Line> result = new ArrayList<Line>(lines.size());
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			if (line.level > level) {
				result.add(line);
			}
		}
		return result;
	}

}
