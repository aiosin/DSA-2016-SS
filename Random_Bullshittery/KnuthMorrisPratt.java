package de.unistuttgart.dsass2016.ex08.p1;

public class KnuthMorrisPratt {

	public KnuthMorrisPratt() {
	}

	/**
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public int KMP(String text, String pattern) {
		int[] prefixTable = generatePrefixTable(pattern);

		// i = textIndex;
		int textIndex = 0;

		// j = patternindex
		int patternIndex = 0;

		while (textIndex < text.length()) {

			// alles super wenn der text übereinstimmt
			if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {

				// ende vom Match, return/break
				if (patternIndex == pattern.length() - 1) {
					return textIndex - patternIndex;
				}
				textIndex++;
				patternIndex++;

			} else if (patternIndex > 0) {
				// shift des patterns nach präfix
				patternIndex = prefixTable[patternIndex - 1];
			} else {
				// kein match und textindex == 0 also weiter gehts
				textIndex++;
			}
		}

		return -1;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public int[] generatePrefixTable(String pattern) {

		int[] prefixTable = new int[pattern.length()];

		int i = 1;
		int j = 0;

		prefixTable[0] = 0;

		while (i < pattern.length()) {
			if (pattern.charAt(j) == pattern.charAt(i)) {
				prefixTable[i] = j + 1;
				j++;
				i++;

			} else if (j > 0) {
				j = prefixTable[j - 1];
			} else {
				prefixTable[i] = 0;
				i++;
			}
		}

		return prefixTable;

	}

}
