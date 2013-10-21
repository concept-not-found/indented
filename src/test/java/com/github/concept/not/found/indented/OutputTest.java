package com.github.concept.not.found.indented;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.concept.not.found.indented.formatter.HtmlListFormatter;
import com.github.concept.not.found.indented.formatter.TabbedFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * Test various ParagraphFormatters.
 */
public class OutputTest {

	private static final Paragraph SAMPLE_PARAGRAPH = createSampleParagraph();
	private static final String LINE_1_UNINDENTED = "1st is unindented";
	private static final String LINE_2_INDENTED = "2nd line is indented";
	private static final String LINE_3_DOUBLE_INDENTED = "3rd line is double indented";
	private static final String LINE_4_UNINDENTED = "4th line is unindented";

	@Test
	public void ensureCorrectHtmlListOutput() {
		ParagraphFormatter formater = new HtmlListFormatter();

		String expected = createExpectedHtmlList();
		String result = formater.format(SAMPLE_PARAGRAPH);

		assertEquals(expected, result);
	}

	@Test
	public void ensureCorrectTabbedOutput() {
		ParagraphFormatter formater = new TabbedFormatter();

		String expected = createExpectedTabbedList();
		String result = formater.format(SAMPLE_PARAGRAPH);

		assertEquals(expected, result);
	}

	private String createExpectedHtmlList() {
		return unorderedList(
				LINE_1_UNINDENTED +
				unorderedList(
						LINE_2_INDENTED +
						unorderedList(
								LINE_3_DOUBLE_INDENTED
						)
				),
				LINE_4_UNINDENTED
		);
	}

	private String createExpectedTabbedList() {
		StringBuilder expected = new StringBuilder();
		expected.append(LINE_1_UNINDENTED);
		expected.append("\n");
		expected.append("\t");
		expected.append(LINE_2_INDENTED);
		expected.append("\n");
		expected.append("\t");
		expected.append("\t");
		expected.append(LINE_3_DOUBLE_INDENTED);
		expected.append("\n");
		expected.append(LINE_4_UNINDENTED);
		expected.append("\n");
		return expected.toString();
	}

	private String unorderedList(final String... items) {
		return String.format("<ul>%s</ul>", StringUtils.join(createListItems(items), ""));
	}

	private List<String> createListItems(final String... items) {
		List<String> listItems = new ArrayList<String>(items.length);
		for (String item : items) {
			listItems.add(createListItem(item));
		}
		return listItems;
	}

	private String createListItem(final String item) {
		return String.format("<li>%s</li>", item);
	}

	private static Paragraph createSampleParagraph() {
		Paragraph paragraph = new Paragraph();
		paragraph.append(LINE_1_UNINDENTED);
		paragraph.indent();
		paragraph.append(LINE_2_INDENTED);
		paragraph.indent();
		paragraph.append(LINE_3_DOUBLE_INDENTED);
		paragraph.unindent();
		paragraph.unindent();
		paragraph.append(LINE_4_UNINDENTED);
		return paragraph;
	}
}
