package poc.job.interview.problems;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;

public class POCCode {

	private static final char S = 'S';
	private static final char M = 'M';
	private static final char L = 'L';

	private static final String MONDAY = "Mon";
	private static final String TUESDAY = "Tue";
	private static final String WEDNESDAY = "Wed";
	private static final String THURSDAY = "Thu";
	private static final String FRIDAY = "Fri";
	private static final String SATURDAY = "Sat";
	private static final String SUNDAY = "Sun";

	public String sizes(String input) {

		StringBuilder sizes = new StringBuilder();
		StringBuilder small = new StringBuilder();
		StringBuilder medium = new StringBuilder();
		StringBuilder large = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			if (S == input.charAt(i)) {
				small.append(S);
			} else if (M == input.charAt(i)) {
				medium.append(M);
				continue;
			} else if (L == input.charAt(i)) {
				large.append(L);
			}
		}
		return sizes.append(small.toString()).append(medium.toString()).append(large.toString()).toString();
	}

	public int smallestInt(int[] input) {

		List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
		int returnInt = 0;
		for (int i = 1; 1 < 100000; i++) {
			if (!inputList.contains(i)) {
				returnInt = i;
				break;
			}
		}
		return returnInt;
	}

	public String daysAhead(String day, int ahead) {

		Map<String, Integer> dayMap = new HashMap<>();
		dayMap.put(MONDAY, Calendar.MONDAY);
		dayMap.put(TUESDAY, Calendar.TUESDAY);
		dayMap.put(WEDNESDAY, Calendar.WEDNESDAY);
		dayMap.put(THURSDAY, Calendar.THURSDAY);
		dayMap.put(FRIDAY, Calendar.FRIDAY);
		dayMap.put(SATURDAY, Calendar.SATURDAY);
		dayMap.put(SUNDAY, Calendar.SUNDAY);

		Map<Integer, String> calendarMap = new HashMap<>();
		calendarMap.put(Calendar.MONDAY, MONDAY);
		calendarMap.put(Calendar.TUESDAY, TUESDAY);
		calendarMap.put(Calendar.WEDNESDAY, WEDNESDAY);
		calendarMap.put(Calendar.THURSDAY, THURSDAY);
		calendarMap.put(Calendar.FRIDAY, FRIDAY);
		calendarMap.put(Calendar.SATURDAY, SATURDAY);
		calendarMap.put(Calendar.SUNDAY, SUNDAY);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, dayMap.get(day));
		calendar.add(Calendar.DAY_OF_WEEK, ahead);
		return calendarMap.get(calendar.get(Calendar.DAY_OF_WEEK));
	}

	public String getFirstNonRepeating(String input) {

		String returnString = null;
		if (Strings.isNotEmpty(input)) {
			for (int i = 0; i < input.length(); i++) {
				String characterString = Character.toString(input.charAt(i));
				if (1 == getCount(characterString, input)) {
					returnString = characterString.toLowerCase();
					break;
				}
			}
		}
		return returnString;
	}

	private int getCount(String characterString, String input) {

		int count = 0;
		if (!" ".equals(characterString)) {
			for (int j = 0; j < input.length(); j++) {
				if (characterString.equalsIgnoreCase(Character.toString(input.charAt(j)))) {
					count++;
				}
				if (2 == count) {
					count = 0;
					break;
				}
			}
		}
		return count;
	}

	public Map<String, Integer> maxMinAdd(int[] input) {

		Map<String, Integer> returnMap = new HashMap<>();
		int min = 0;
		int max = 0;
		int total = 0;
		if (null != input) {
			for (int i = 0; i < input.length; i++) {
				if (0 == i) {
					min = input[i];
					max = input[i];
				} else {
					if (input[i] < min) {
						min = input[i];
					}
					if (input[i] > max) {
						max = input[i];
					}
				}
				total += input[i];
			}
		}
		returnMap.put("Min", Integer.valueOf(total - max));
		returnMap.put("Max", Integer.valueOf(total - min));
		return returnMap;

	}

}
